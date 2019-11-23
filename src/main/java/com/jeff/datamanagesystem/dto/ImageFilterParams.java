package com.jeff.datamanagesystem.dto;

import java.util.Date;

public class ImageFilterParams {
    private Integer typeID;
    private String country;
    private String position;
    private Double longitude;
    private Double fromX;
    private Double toX;
    private Double latitude;
    private Double fromY;
    private Double toY;
    private Date gatherTime;
    private Double gatherDuration;
    private Double fromDuration;
    private Double toDuration;
    private Double scale;
    private Double fromScale;
    private Double toScale;
    private Double ppi;
    private Double fromPPi;
    private Double toPPi;
    private Date createTime;

    public ImageFilterParams() {
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

    public Double getGatherDuration() {
        return gatherDuration;
    }

    public void setGatherDuration(Double gatherDuration) {
        this.gatherDuration = gatherDuration;
    }

    public Double getScale() {
        return scale;
    }

    public void setScale(Double scale) {
        this.scale = scale;
    }

    public Double getPpi() {
        return ppi;
    }

    public void setPpi(Double ppi) {
        this.ppi = ppi;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getTypeID() {
        return typeID;
    }

    public void setTypeID(Integer typeID) {
        this.typeID = typeID;
    }

    public Double getFromPPi() {
        return fromPPi;
    }

    public void setFromPPi(Double fromPPi) {
        this.fromPPi = fromPPi;
    }

    public Double getToPPi() {
        return toPPi;
    }

    public void setToPPi(Double toPPi) {
        this.toPPi = toPPi;
    }

    public Double getToX() {
        return toX;
    }

    public void setToX(Double toX) {
        this.toX = toX;
    }

    public Double getToY() {
        return toY;
    }

    public void setToY(Double toY) {
        this.toY = toY;
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


    public Double getFromX() {
        return fromX;
    }

    public void setFromX(Double fromX) {
        this.fromX = fromX;
    }

    public Double getFromY() {
        return fromY;
    }

    public void setFromY(Double fromY) {
        this.fromY = fromY;
    }

    public Date getGatherTime() {
        return gatherTime;
    }

    public void setGatherTime(Date gatherTime) {
        this.gatherTime = gatherTime;
    }

    public Double getFromDuration() {
        return fromDuration;
    }

    public void setFromDuration(Double fromDuration) {
        this.fromDuration = fromDuration;
    }

    public Double getToDuration() {
        return toDuration;
    }

    public void setToDuration(Double toDuration) {
        this.toDuration = toDuration;
    }

    public Double getFromScale() {
        return fromScale;
    }

    public void setFromScale(Double fromScale) {
        this.fromScale = fromScale;
    }

    public Double getToScale() {
        return toScale;
    }

    public void setToScale(Double toScale) {
        this.toScale = toScale;
    }

    @Override
    public String toString() {
        return "ImageFilterParams{" +
                "typeID='" + typeID + '\'' +
                ", country='" + country + '\'' +
                ", position='" + position + '\'' +
                ", fromX=" + fromX +
                ", toX=" + toX +
                ", fromY=" + fromY +
                ", toY=" + toY +
                ", gatherTime=" + gatherTime +
                ", fromDuration=" + fromDuration +
                ", toDuration=" + toDuration +
                ", fromScale=" + fromScale +
                ", toScale=" + toScale +
                ", fromPPi=" + fromPPi +
                ", toPPi=" + toPPi +
                '}';
    }
}
