package com.jeff.data_manage_system.mapper;

import com.jeff.data_manage_system.dto.ImageFilterParams;
import com.jeff.data_manage_system.entity.ImageInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.List;

@Mapper
@Repository
public interface ImageInfoMapper {

    @Select("select count(id) from image where type_id=#{typeID}")
    Long getCountByTypeID(Integer typeID);

    @Insert("insert into image (country, position, type_id, ppi, location_x, location_y, gather_time, gather_duration, " +
            "scale, user_id, url, thumb_url, create_time, update_time) values(#{country}, #{position}, #{typeID}, #{ppi}, #{longitude}, " +
            "#{latitude}, #{gatherTime}, #{gatherDuration}, #{scale}, #{userID}, #{url}, #{thumbUrl}, #{createTime}, #{updateTime})")
    @Options(useGeneratedKeys = true)
    int addImageInfo(ImageInfo imageInfo);

    @Update("update image set country=#{country}, position=#{position}, type_id=#{typeID}, ppi=#{ppi}, location_x=#{longitude}, " +
            "location_x=#{latitude}, gather_time=#{gatherTime}, gather_duration=#{gatherDuration}, scale=#{scale}, " +
            "url=#{url}, thumb_url=#{thumbUrl}, update_time=#{updateTime} where id=#{id}")
    int updateImageInfo(ImageInfo imageInfo);

    @Delete("delete from image where id = #{id}")
    int deleteImageInfo(Integer id);

    @Results(id = "image", value = {
            @Result(column = "id", property = "id"),
            @Result(column = "country", property = "country"),
            @Result(column = "position", property = "position"),
            @Result(column = "type_id", property = "typeID"),
            @Result(column = "ppi", property = "ppi"),
            @Result(column = "location_x", property = "longitude"),
            @Result(column = "location_y", property = "latitude"),
            @Result(column = "gather_time", property = "gatherTime"),
            @Result(column = "gather_duration", property = "gatherDuration"),
            @Result(column = "scale", property = "scale"),
            @Result(column = "user_id", property = "userID"),
            @Result(column = "type_id", property = "type",
                    one = @One(select = "com.jeff.data_manage_system.mapper.TypeMapper.getTypeNameByID", fetchType = FetchType.LAZY)),
            @Result(column = "url", property = "url"),
            @Result(column = "thumb_url", property = "thumbUrl"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime"),
    })
    @Select("select id, country, ppi, position, type_id, location_x, location_y, gather_time, gather_duration, scale, user_id, url, thumb_url, " +
            "create_time, update_time from image where id=#{id} limit 1")
    ImageInfo getImageInfo(Integer id);

    @ResultMap("image")
    @Select("select id, country, ppi, position, type_id, location_x, location_y, gather_time, gather_duration, scale, user_id, url, thumb_url, " +
            "create_time, update_time from image where user_id=#{id}")
    List<ImageInfo> getImageInfoListByUserID(Integer id);

    @ResultMap("image")
    @Select("select id, country, ppi, position, type_id, location_x, location_y, gather_time, gather_duration, scale, user_id, url, thumb_url, " +
            "create_time, update_time from image where type_id=#{id}")
    List<ImageInfo> getImageInfoListByTypeID(Integer id);


    @ResultMap("image")
    @SelectProvider(type = ImageInfoMapperProvider.class, method = "getImageInfoList")
    List<ImageInfo> getImageInfoList(ImageFilterParams imageFilterParams);

    class ImageInfoMapperProvider{
        public String getImageInfoList(final ImageFilterParams imageFilterParams){
            return new SQL(){{
                SELECT("id, country, ppi, position, type_id, location_x, location_y, gather_time, gather_duration, scale, " +
                        "user_id, url, thumb_url, create_time, update_time");
                FROM("image");
                if(imageFilterParams != null){
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    if(imageFilterParams.getTypeID() != null)
                        WHERE("type_id like concat('%', #{typeID}, '%')");
                    if(imageFilterParams.getCountry() != null)
                        WHERE("country like concat('%', #{country}, '%')");
                    if(imageFilterParams.getPosition() != null)
                        WHERE("position like concat('%', #{position}, '%')");
                    if(imageFilterParams.getGatherTime() != null)
                        WHERE("gather_time like concat('%" + simpleDateFormat.format(imageFilterParams.getGatherTime()) + "%')");
                    if(imageFilterParams.getGatherDuration() != null)
                        WHERE("gather_duration like concat('%', #{gatherDuration}, '%')");
                    if(imageFilterParams.getLatitude() != null)
                        WHERE("location_y like concat('%', #{latitude}, '%')");
                    if(imageFilterParams.getLongitude() != null)
                        WHERE("location_x like concat('%', #{longitude}, '%')");
                    if(imageFilterParams.getPpi() != null)
                        WHERE("ppi like concat('%', #{ppi}, '%')");
                    if(imageFilterParams.getScale() != null)
                        WHERE("scale like concat('%', #{scale}, '%')");
                    if(imageFilterParams.getCreateTime() != null)
                        WHERE("create_time like concat('%" + simpleDateFormat.format(imageFilterParams.getCreateTime()) + "%')");
                    if(imageFilterParams.getFromX() != null)
                        WHERE("location_x >= #{fromX}");
                    if(imageFilterParams.getToX() != null)
                        WHERE("location_x <= #{toX}");
                    if(imageFilterParams.getFromY() != null)
                        WHERE("location_y >= #{fromY}");
                    if(imageFilterParams.getToY() != null)
                        WHERE("location_y <= #{toY}");
                    if(imageFilterParams.getFromDuration() != null)
                        WHERE("gather_duration >= #{fromDuration}");
                    if(imageFilterParams.getToDuration() != null)
                        WHERE("gather_duration <= #{toDuration}");
                    if(imageFilterParams.getFromScale() != null)
                        WHERE("scale >= #{fromScale}");
                    if(imageFilterParams.getToScale() != null)
                        WHERE("scale <= #{toScale}");
                    if(imageFilterParams.getFromPPi() != null)
                        WHERE("ppi >= #{fromPPi}");
                    if(imageFilterParams.getToPPi() != null)
                        WHERE("ppi <= #{toPPi}");
                }
            }}.toString();
        }
    }
}
