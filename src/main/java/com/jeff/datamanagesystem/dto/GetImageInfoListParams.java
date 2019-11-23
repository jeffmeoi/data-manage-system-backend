package com.jeff.datamanagesystem.dto;


public class GetImageInfoListParams {
    private ImageFilterParams imageFilterParams;
    private ListParams listParams;

    public GetImageInfoListParams() {
    }

    public GetImageInfoListParams(ImageFilterParams imageFilterParams, ListParams listParams) {
        this.imageFilterParams = imageFilterParams;
        this.listParams = listParams;
    }

    public ImageFilterParams getImageFilterParams() {
        return imageFilterParams;
    }

    public void setImageFilterParams(ImageFilterParams imageFilterParams) {
        this.imageFilterParams = imageFilterParams;
    }

    public ListParams getListParams() {
        return listParams;
    }

    public void setListParams(ListParams listParams) {
        this.listParams = listParams;
    }

    @Override
    public String toString() {
        return "GetImageInfoListParams{" +
                "imageFilterParams=" + imageFilterParams +
                ", listParams=" + listParams +
                '}';
    }
}
