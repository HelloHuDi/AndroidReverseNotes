package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionWrapper;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.c;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class DrawCanvasArg implements Parcelable {
    public static final Creator<DrawCanvasArg> CREATOR = new Creator<DrawCanvasArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DrawCanvasArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103701);
            DrawCanvasArg drawCanvasArg = new DrawCanvasArg(parcel);
            AppMethodBeat.o(103701);
            return drawCanvasArg;
        }
    };
    public boolean hdU;
    public String hdV;
    public long hdW;
    public boolean hdX;
    public JSONArray hdY;
    public volatile Runnable hdZ;
    public List<DrawActionWrapper> hdv = new ArrayList();
    private volatile boolean hea = false;
    public volatile boolean heb = false;
    protected volatile int hec;
    protected volatile int hed;

    static /* synthetic */ void a(DrawCanvasArg drawCanvasArg, JSONArray jSONArray) {
        AppMethodBeat.i(103708);
        drawCanvasArg.h(jSONArray);
        AppMethodBeat.o(103708);
    }

    static /* synthetic */ void f(DrawCanvasArg drawCanvasArg) {
        AppMethodBeat.i(103709);
        drawCanvasArg.release();
        AppMethodBeat.o(103709);
    }

    public DrawCanvasArg() {
        AppMethodBeat.i(103702);
        AppMethodBeat.o(103702);
    }

    public DrawCanvasArg(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.i(103703);
        this.hdU = parcel.readInt() == 1;
        this.hdV = parcel.readString();
        this.hdv = parcel.readArrayList(DrawCanvasArg.class.getClassLoader());
        this.hdW = parcel.readLong();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.hdX = z;
        AppMethodBeat.o(103703);
    }

    public final void h(JSONArray jSONArray) {
        DrawActionWrapper drawActionWrapper;
        AppMethodBeat.i(103704);
        for (int i = 0; i < jSONArray.length() && !this.hea; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            BaseDrawActionArg yy = c.ayj().yy(optJSONObject.optString(b.METHOD));
            drawActionWrapper = (DrawActionWrapper) d.ayk().hdA.aA();
            if (drawActionWrapper == null) {
                drawActionWrapper = new DrawActionWrapper();
            }
            if (yy != null) {
                drawActionWrapper.type = 2;
                yy.j(optJSONObject);
                drawActionWrapper.hcP = yy;
            } else {
                drawActionWrapper.type = 1;
                drawActionWrapper.hcQ = optJSONObject;
            }
            this.hdv.add(drawActionWrapper);
        }
        LinkedList linkedList = new LinkedList();
        ArrayList<DrawActionWrapper> arrayList = new ArrayList();
        this.hed += this.hdv.size();
        int size = this.hdv.size() - 1;
        int i2 = 0;
        while (size >= 0) {
            boolean z;
            int i3;
            drawActionWrapper = (DrawActionWrapper) this.hdv.get(size);
            switch (drawActionWrapper.type) {
                case 1:
                    z = false;
                    break;
                case 2:
                    z = drawActionWrapper.hcP.ayg();
                    break;
                default:
                    z = false;
                    break;
            }
            if (z) {
                ab.i("DrawCanvasArg", "found redudant method %s", drawActionWrapper.getMethod());
                arrayList.add(drawActionWrapper);
                i3 = i2 + 1;
            } else {
                if (!"save".equals(drawActionWrapper.getMethod())) {
                    linkedList.addLast(drawActionWrapper);
                } else if (linkedList.size() <= 0 || !((DrawActionWrapper) linkedList.getLast()).getMethod().equals("restore")) {
                    while (linkedList.size() > 0) {
                        if (((DrawActionWrapper) linkedList.removeLast()).getMethod().equals("restore")) {
                            i3 = i2;
                        }
                    }
                } else {
                    arrayList.add(drawActionWrapper);
                    arrayList.add(linkedList.removeLast());
                    i3 = i2;
                }
                i3 = i2;
            }
            size--;
            i2 = i3;
        }
        this.hec += arrayList.size();
        for (DrawActionWrapper drawActionWrapper2 : arrayList) {
            this.hdv.remove(drawActionWrapper2);
            drawActionWrapper2.reset();
        }
        ab.i("DrawCanvasArg", "optimize save&restore %d times, redudant count %d, allOpCount %d ", Integer.valueOf(this.hec), Integer.valueOf(i2), Integer.valueOf(this.hed));
        AppMethodBeat.o(103704);
    }

    public final void reset() {
        AppMethodBeat.i(103705);
        if (this.hdZ == null || com.tencent.mm.sdk.g.d.xDG.remove(this.hdZ)) {
            release();
            AppMethodBeat.o(103705);
            return;
        }
        ab.i("DrawCanvasArg", "wait for async over");
        this.hea = true;
        AppMethodBeat.o(103705);
    }

    private synchronized void release() {
        AppMethodBeat.i(103706);
        ab.i("DrawCanvasArg", "release %s", toString());
        this.hed = 0;
        this.hec = 0;
        this.hdZ = null;
        this.hdU = false;
        this.hdY = null;
        this.hdV = null;
        this.hdW = 0;
        this.hdX = false;
        this.hea = false;
        this.heb = false;
        Iterator it = this.hdv.iterator();
        while (it.hasNext()) {
            DrawActionWrapper drawActionWrapper = (DrawActionWrapper) it.next();
            if (drawActionWrapper != null) {
                drawActionWrapper.reset();
            }
            it.remove();
        }
        d.ayk().hdz.release(this);
        AppMethodBeat.o(103706);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        AppMethodBeat.i(103707);
        parcel.writeInt(this.hdU ? 1 : 0);
        parcel.writeString(this.hdV);
        parcel.writeList(this.hdv);
        parcel.writeLong(this.hdW);
        if (!this.hdX) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        AppMethodBeat.o(103707);
    }

    static {
        AppMethodBeat.i(103710);
        AppMethodBeat.o(103710);
    }
}
