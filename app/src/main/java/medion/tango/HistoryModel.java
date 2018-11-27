package medion.tango;

import com.google.gson.annotations.SerializedName;

public class HistoryModel {
    @SerializedName("custname")
    private String custname;
    @SerializedName("plasmaname")
    private String plasmaname;
    @SerializedName("tanggal")
    private String tanggal;
    @SerializedName("populasi")
    private String populasi;
    @SerializedName("jenis")
    private String jenis;

    public HistoryModel(String custname, String plasmaname, String tanggal, String populasi, String jenis) {
        this.custname = custname;
        this.plasmaname = plasmaname;
        this.tanggal = tanggal;
        this.populasi = populasi;
        this.jenis = jenis;
    }

    public String getCustName() {return custname;}
    public void setCustName(String custname) {this.custname = custname;}

    public String getPlasmaName() {return plasmaname;}
    public void setPlasmaName(String plasmaname) {this.plasmaname = plasmaname;}

    public String getTanggal() {return tanggal;}
    public void setTanggal(String tanggal) {this.tanggal = tanggal;}

    public String getPopulasi() {return populasi;}
    public void setPopulasi(String populasi) {this.populasi = populasi;}

    public String getJenis() {return jenis;}
    public void setJenis(String jenis) {this.jenis = jenis;}
}
