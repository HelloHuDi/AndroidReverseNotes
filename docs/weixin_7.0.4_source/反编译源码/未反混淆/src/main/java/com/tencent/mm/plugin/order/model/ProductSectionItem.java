package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class ProductSectionItem implements Parcelable {
    public static final Creator<ProductSectionItem> CREATER = new Creator<ProductSectionItem>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ProductSectionItem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(43783);
            ProductSectionItem productSectionItem = new ProductSectionItem(parcel);
            AppMethodBeat.o(43783);
            return productSectionItem;
        }
    };
    public int count;
    public String iconUrl;
    public String jumpUrl;
    public String name;
    public String pdA;
    public List<Skus> pdy;
    public String pdz;
    public int scene;

    public static class Skus implements Parcelable {
        public static final Creator<Skus> CREATER = new Creator<Skus>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new Skus[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(43784);
                Skus skus = new Skus(parcel);
                AppMethodBeat.o(43784);
                return skus;
            }
        };
        public String key;
        public String value;

        public Skus(Parcel parcel) {
            AppMethodBeat.i(43785);
            this.key = parcel.readString();
            this.value = parcel.readString();
            AppMethodBeat.o(43785);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(43786);
            parcel.writeString(this.key);
            parcel.writeString(this.value);
            AppMethodBeat.o(43786);
        }

        static {
            AppMethodBeat.i(43788);
            AppMethodBeat.o(43788);
        }

        public static String ct(List<Skus> list) {
            AppMethodBeat.i(43787);
            String str;
            if (list == null || list.size() == 0) {
                str = "";
                AppMethodBeat.o(43787);
                return str;
            }
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    Skus skus = (Skus) list.get(i2);
                    if (i2 != 0) {
                        stringBuilder.append("、");
                    }
                    stringBuilder.append(skus.value);
                    i = i2 + 1;
                } else {
                    str = stringBuilder.toString();
                    AppMethodBeat.o(43787);
                    return str;
                }
            }
        }
    }

    public ProductSectionItem(Parcel parcel) {
        AppMethodBeat.i(43789);
        this.iconUrl = parcel.readString();
        this.name = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.pdy = new ArrayList();
            for (int i = 0; i < readInt; i++) {
                Skus skus = new Skus();
                skus.key = parcel.readString();
                skus.value = parcel.readString();
                this.pdy.add(skus);
            }
        }
        this.count = parcel.readInt();
        this.pdz = parcel.readString();
        this.jumpUrl = parcel.readString();
        this.pdA = parcel.readString();
        this.scene = parcel.readInt();
        AppMethodBeat.o(43789);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        AppMethodBeat.i(43790);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.name);
        if (this.pdy != null) {
            parcel.writeInt(this.pdy.size());
            while (true) {
                int i3 = i2;
                if (i3 >= this.pdy.size()) {
                    break;
                }
                Skus skus = (Skus) this.pdy.get(i3);
                parcel.writeString(skus.key);
                parcel.writeString(skus.value);
                i2 = i3 + 1;
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.count);
        parcel.writeString(this.pdz);
        parcel.writeString(this.jumpUrl);
        parcel.writeString(this.pdA);
        parcel.writeInt(this.scene);
        AppMethodBeat.o(43790);
    }

    static {
        AppMethodBeat.i(43791);
        AppMethodBeat.o(43791);
    }
}
