package isdc.isdcssm.dto.Request;

public class DownloadRequest
{
    private String times;
    private String email;

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getTimes()
    {
        return times;
    }

    public void setTimes(String times)
    {
        this.times = times;
    }
}
