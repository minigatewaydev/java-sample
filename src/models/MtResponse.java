package models;

import java.util.List;

/**
 * MtResponse
 */
public class MtResponse {

    public String username;
    public String chargingPlan;
    public String message;
    public int creditDeducted;
    public MtInfo submitted;
    public List<Mt> mtList;
    public boolean isSuccess;

}