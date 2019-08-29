package isdc.isdcssm.service;

import isdc.isdcssm.model.ApplicationForm;

import java.io.InputStream;
import java.util.List;

public interface FileService
{
    String getRootPath();

    String getCurrentPath(String accessToken);

    String queryAll();

    InputStream DownloadStream(String times, String email);
}
