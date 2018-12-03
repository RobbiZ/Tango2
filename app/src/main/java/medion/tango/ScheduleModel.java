package medion.tango;

import com.google.gson.annotations.SerializedName;

public class ScheduleModel {
    @SerializedName("vacid")
    private String vacid;
    @SerializedName("custname")
    private String custname;
    @SerializedName("plasmaname")
    private String plasmaname;
    @SerializedName("address")
    private String address;
    @SerializedName("city")
    private String city;
    @SerializedName("phone")
    private String phone;
    @SerializedName("area")
    private String area;
    @SerializedName("tanggal")
    private String tanggal;
    @SerializedName("populasi")
    private String populasi;
    @SerializedName("jenis")
    private String jenis;
    @SerializedName("umur")
    private String umur;
    @SerializedName("aplikasi")
    private String aplikasi;
    @SerializedName("productname")
    private String productname;

    public ScheduleModel(String vacid, String custname, String plasmaname, String address,
                         String city, String phone, String area, String tanggal, String populasi,
                         String jenis, String umur, String aplikasi, String productname) {

        this.vacid = vacid;
        this.custname = custname;
        this.plasmaname = plasmaname;
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.area = area;
        this.tanggal = tanggal;
        this.populasi = populasi;
        this.jenis = jenis;
        this.umur = umur;
        this.aplikasi = aplikasi;
        this.productname = productname;
    }

    public String getVacid() {return vacid;}
    public void setVacid(String vacid) {this.vacid = vacid;}

    public String getCustName() {return custname;}
    public void setCustName(String custname) {this.custname = custname;}

    public String getPlasmaName() {return plasmaname;}
    public void setPlasmaName(String plasmaname) {this.plasmaname = plasmaname;}

    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}

    public String getCity() {return city;}
    public void setCity(String city) {this.city = city;}

    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}

    public String getArea() {return area;}
    public void setArea(String area) {this.area = area;}

    public String getTanggal() {return tanggal;}
    public void setTanggal(String tanggal) {this.tanggal = tanggal;}

    public String getPopulasi() {return populasi;}
    public void setPopulasi(String populasi) {this.populasi = populasi;}

    public String getJenis() {return jenis;}
    public void setJenis(String jenis) {this.jenis = jenis;}

    public String getUmur() {return umur;}
    public void setUmur(String umur) {this.umur = umur;}

    public String getAplikasi() {return aplikasi;}
    public void setAplikasi(String aplikasi) {this.aplikasi= aplikasi;}

    public String getProductname() {return productname;}
    public void setProductname(String productname) {this.productname = productname;}
}
