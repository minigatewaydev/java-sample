package models;

import com.google.gson.annotations.SerializedName;

/**
 * Mtrequest
 */
public class MtRequest {

    public static final String GW_USERNAME = "gw-username";
    public static final String GW_PASSWORD = "gw-password";
    public static final String GW_FROM = "gw-from";
    public static final String GW_TO = "gw-to";
    public static final String GW_TEXT = "gw-text";
    public static final String GW_CODING = "gw-coding";
    public static final String GW_DLR_MASK = "gw-dlr-mask";
    public static final String GW_DLR_URL = "gw-dlr-url";
    public static final String GW_RESP_TYPE = "gw-resp-type";

    @SerializedName(GW_USERNAME)
    public String username;

    @SerializedName(GW_PASSWORD)
    public String password;

    @SerializedName(GW_FROM)
    public String from;
    
    @SerializedName(GW_TO)
    public String to;

    @SerializedName(GW_TEXT)
    public String text;

    @SerializedName(GW_CODING)
    public String coding;

    @SerializedName(GW_DLR_MASK)
    public String dlrMask;

    @SerializedName(GW_DLR_URL)
    public String dlrUrl;

    @SerializedName(GW_RESP_TYPE)
    public String responseType;
}