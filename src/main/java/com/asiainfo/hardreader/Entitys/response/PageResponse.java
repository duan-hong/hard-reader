package com.asiainfo.hardreader.Entitys.response;

import com.asiainfo.hardreader.Entitys.response.BaseResponse;

/**
 * @author duanhong
 * @description 分页响应类
 * @date 2019/11/23
 */
public class PageResponse extends BaseResponse {
    private long pageNum;
    private long getPageSize;
    private long pageCount;

    public long getPageNum() {
        return pageNum;
    }

    public void setPageNum(long pageNum) {
        this.pageNum = pageNum;
    }

    public long getGetPageSize() {
        return getPageSize;
    }

    public void setGetPageSize(long getPageSize) {
        this.getPageSize = getPageSize;
    }

    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }
}
