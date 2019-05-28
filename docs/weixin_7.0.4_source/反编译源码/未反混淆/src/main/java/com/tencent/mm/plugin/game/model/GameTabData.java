package com.tencent.mm.plugin.game.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.game.d.al;
import com.tencent.mm.plugin.game.d.dd;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.ui.tab.GameTabHomeUI;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public class GameTabData implements Parcelable {
    public static final Creator<GameTabData> CREATOR = new Creator<GameTabData>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GameTabData[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(111390);
            GameTabData gameTabData = new GameTabData(parcel, (byte) 0);
            AppMethodBeat.o(111390);
            return gameTabData;
        }
    };
    public LinkedHashMap<String, TabItem> mYm;
    public StatusBar mYn;

    public static class TabItem implements Parcelable {
        public static final Creator<TabItem> CREATOR = new Creator<TabItem>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new TabItem[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(111395);
                TabItem tabItem = new TabItem(parcel);
                AppMethodBeat.o(111395);
                return tabItem;
            }
        };
        public int cKG;
        public String jumpUrl;
        public String mVB;
        public String mYp;
        public boolean mYq;
        public boolean mYr;
        public int mYs;
        public int mYt;
        public String mYu;
        public String mYv;
        public String mYw;
        public boolean mYx;
        public int mYy;
        public String title;

        public TabItem(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(111396);
            this.mYp = parcel.readString();
            this.title = parcel.readString();
            this.jumpUrl = parcel.readString();
            this.mYq = parcel.readByte() != (byte) 0;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.mYr = z;
            this.mYs = parcel.readInt();
            this.mYt = parcel.readInt();
            this.mYu = parcel.readString();
            this.mYv = parcel.readString();
            this.mYw = parcel.readString();
            if (parcel.readByte() == (byte) 0) {
                z2 = false;
            }
            this.mYx = z2;
            this.cKG = parcel.readInt();
            this.mYy = parcel.readInt();
            this.mVB = parcel.readString();
            AppMethodBeat.o(111396);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            int i3 = 1;
            AppMethodBeat.i(111397);
            parcel.writeString(this.mYp);
            parcel.writeString(this.title);
            parcel.writeString(this.jumpUrl);
            parcel.writeByte((byte) (this.mYq ? 1 : 0));
            if (this.mYr) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeByte((byte) i2);
            parcel.writeInt(this.mYs);
            parcel.writeInt(this.mYt);
            parcel.writeString(this.mYu);
            parcel.writeString(this.mYv);
            parcel.writeString(this.mYw);
            if (!this.mYx) {
                i3 = 0;
            }
            parcel.writeByte((byte) i3);
            parcel.writeInt(this.cKG);
            parcel.writeInt(this.mYy);
            parcel.writeString(this.mVB);
            AppMethodBeat.o(111397);
        }

        static {
            AppMethodBeat.i(111398);
            AppMethodBeat.o(111398);
        }
    }

    public static class StatusBar implements Parcelable {
        public static final Creator<StatusBar> CREATOR = new Creator<StatusBar>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StatusBar[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(111391);
                StatusBar statusBar = new StatusBar(parcel);
                AppMethodBeat.o(111391);
                return statusBar;
            }
        };
        public int color = 0;
        public String mYo = null;

        public StatusBar(Parcel parcel) {
            AppMethodBeat.i(111392);
            this.mYo = parcel.readString();
            this.color = parcel.readInt();
            AppMethodBeat.o(111392);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(111393);
            parcel.writeString(this.mYo);
            parcel.writeInt(this.color);
            AppMethodBeat.o(111393);
        }

        static {
            AppMethodBeat.i(111394);
            AppMethodBeat.o(111394);
        }
    }

    /* synthetic */ GameTabData(Parcel parcel, byte b) {
        this(parcel);
    }

    public final List<TabItem> getItemList() {
        AppMethodBeat.i(111399);
        ArrayList arrayList = new ArrayList();
        if (this.mYm != null) {
            arrayList.addAll(this.mYm.values());
        }
        AppMethodBeat.o(111399);
        return arrayList;
    }

    public GameTabData() {
        AppMethodBeat.i(111400);
        this.mYm = new LinkedHashMap();
        this.mYn = new StatusBar();
        AppMethodBeat.o(111400);
    }

    private GameTabData(Parcel parcel) {
        AppMethodBeat.i(111401);
        g(parcel);
        AppMethodBeat.o(111401);
    }

    public int describeContents() {
        return 0;
    }

    private void g(Parcel parcel) {
        AppMethodBeat.i(111402);
        int readInt = parcel.readInt();
        if (this.mYm == null) {
            this.mYm = new LinkedHashMap();
        }
        for (int i = 0; i < readInt; i++) {
            TabItem tabItem = (TabItem) parcel.readParcelable(TabItem.class.getClassLoader());
            if (tabItem != null) {
                this.mYm.put(tabItem.mYp, tabItem);
            }
        }
        this.mYn = (StatusBar) parcel.readParcelable(StatusBar.class.getClassLoader());
        AppMethodBeat.o(111402);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(111403);
        parcel.writeInt(this.mYm.size());
        for (Entry value : this.mYm.entrySet()) {
            parcel.writeParcelable((Parcelable) value.getValue(), i);
        }
        parcel.writeParcelable(this.mYn, i);
        AppMethodBeat.o(111403);
    }

    static {
        AppMethodBeat.i(111405);
        AppMethodBeat.o(111405);
    }

    public static GameTabData cc(List<al> list) {
        AppMethodBeat.i(111404);
        if (bo.ek(list)) {
            AppMethodBeat.o(111404);
            return null;
        }
        GameTabData gameTabData = new GameTabData();
        dd bDg = a.bDg();
        if (bDg != null) {
            gameTabData.mYn.mYo = bDg.mYo;
            gameTabData.mYn.color = c.parseColor(bDg.color);
        }
        int i = 0;
        for (al alVar : list) {
            if (!(alVar == null || bo.isNullOrNil(alVar.naV))) {
                TabItem tabItem = new TabItem();
                tabItem.mYp = alVar.naV;
                tabItem.title = alVar.Title;
                tabItem.mYq = alVar.naW;
                tabItem.mYr = alVar.naX;
                tabItem.jumpUrl = alVar.mZj;
                tabItem.mYu = alVar.naY;
                tabItem.mYv = alVar.naZ;
                if (tabItem.mYr) {
                    tabItem.mYw = GameTabHomeUI.class.getName();
                } else {
                    int i2 = i + 1;
                    i %= 3;
                    tabItem.mYw = "com.tencent.mm.plugin.game.ui.tab.GameTabWebUI" + (i != 0 ? String.valueOf(i) : "");
                    i = i2;
                }
                tabItem.mYx = false;
                tabItem.cKG = alVar.nba;
                tabItem.mYy = alVar.mZN;
                tabItem.mVB = alVar.mZL;
                gameTabData.mYm.put(tabItem.mYp, tabItem);
            }
        }
        AppMethodBeat.o(111404);
        return gameTabData;
    }
}
