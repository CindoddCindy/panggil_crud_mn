
package cindy.test.apipost.pojo;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class GetPostResponData {

    @SerializedName("data")
    @Expose
    private List<Datum> data = new ArrayList<Datum>();
    @SerializedName("page")
    @Expose
    private double page;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GetPostResponData() {
    }

    /**
     * 
     * @param data
     * @param page
     */
    public GetPostResponData(List<Datum> data, double page) {
        super();
        this.data = data;
        this.page = page;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public GetPostResponData withData(List<Datum> data) {
        this.data = data;
        return this;
    }

    public double getPage() {
        return page;
    }

    public void setPage(double page) {
        this.page = page;
    }

    public GetPostResponData withPage(double page) {
        this.page = page;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("data", data).append("page", page).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(data).append(page).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GetPostResponData) == false) {
            return false;
        }
        GetPostResponData rhs = ((GetPostResponData) other);
        return new EqualsBuilder().append(data, rhs.data).append(page, rhs.page).isEquals();
    }

}
