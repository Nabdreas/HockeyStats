package pb.co.uk.hockeystats.service.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("updated")
    @Expose
    public String updated;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("continent")
    @Expose
    public String continent;
    @SerializedName("shortName")
    @Expose
    public String shortName;
    @SerializedName("abbreviation")
    @Expose
    public String abbreviation;
    @SerializedName("iso3166_2")
    @Expose
    public String iso31662;
    @SerializedName("iso3166_3")
    @Expose
    public String iso31663;
}