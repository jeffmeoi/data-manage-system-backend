package com.jeff.datamanagesystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(value = {"handler", "columns"})
public class ImageInfo {

    public static String[] columns = new String[]{
            "id", "country", "position", "type_id", "ppi", "longitude", "latitude", "gather_time", "gather_duration",
            "scale", "url", "thumbUrl", "user_id", "create_time", "update_time"
    };

    private Integer id;
    private String country;
    private String position;
    private Integer typeID;
    private String type;
    private Double ppi;
    private Double longitude;
    private Double latitude;
    private Date gatherTime;
    private Integer gatherDuration;
    private Double scale;
    private String url;
    private String thumbUrl;
    private Integer userID;
    private Date createTime;
    private Date updateTime;


    public ImageInfo() {
    }

    public ImageInfo(Integer id, String country, String position, Integer typeID, Double ppi, Double longitude, Double latitude, Date gatherTime, Integer gatherDuration, Double scale, String url, String thumbUrl, Integer userID, Date createTime, Date updateTime) {
        this.id = id;
        this.country = country;
        this.position = position;
        this.typeID = typeID;
        this.ppi = ppi;
        this.longitude = longitude;
        this.latitude = latitude;
        this.gatherTime = gatherTime;
        this.gatherDuration = gatherDuration;
        this.scale = scale;
        this.url = url;
        this.thumbUrl = thumbUrl;
        this.userID = userID;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getTypeID() {
        return typeID;
    }

    public void setTypeID(Integer typeID) {
        this.typeID = typeID;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    public Double getPpi() {
        return ppi;
    }

    public void setPpi(Double ppi) {
        this.ppi = ppi;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getGatherTime() {
        return gatherTime;
    }

    public void setGatherTime(Date gatherTime) {
        this.gatherTime = gatherTime;
    }

    public Integer getGatherDuration() {
        return gatherDuration;
    }

    public void setGatherDuration(Integer gatherDuration) {
        this.gatherDuration = gatherDuration;
    }

    public Double getScale() {
        return scale;
    }

    public void setScale(Double scale) {
        this.scale = scale;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }



    @Override
    public String toString() {
        return "ImageInfo{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", position='" + position + '\'' +
                ", typeID=" + typeID +
                ", type='" + type + '\'' +
                ", ppi=" + ppi +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", gatherTime=" + gatherTime +
                ", gatherDuration=" + gatherDuration +
                ", scale=" + scale +
                ", url='" + url + '\'' +
                ", thumbUrl='" + thumbUrl + '\'' +
                ", userID=" + userID +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
