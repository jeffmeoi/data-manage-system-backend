package com.jeff.datamanagesystem.service;

import java.io.IOException;
import java.util.List;

public interface ExcelService {
    List GetImageInfoList() throws IOException;
    List GetTypeList () throws IOException;
    List GetUserList() throws IOException;
}
