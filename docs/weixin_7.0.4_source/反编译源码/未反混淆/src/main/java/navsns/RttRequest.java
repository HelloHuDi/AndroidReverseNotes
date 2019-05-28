package navsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.i;
import com.tencent.tencentmap.mapsdk.maps.a.k;
import com.tencent.tencentmap.mapsdk.maps.a.l;
import com.tencent.tencentmap.mapsdk.maps.a.m;
import com.tencent.tencentmap.mapsdk.maps.a.n;
import java.util.ArrayList;

public final class RttRequest extends m implements Cloneable {
    static ArrayList<Integer> a = new ArrayList();
    static final /* synthetic */ boolean b;
    public ArrayList<Integer> bounds = null;
    public short zip = (short) 0;
    public short zoom = (short) 0;

    static {
        boolean z;
        AppMethodBeat.i(101135);
        if (RttRequest.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        b = z;
        a.add(Integer.valueOf(0));
        AppMethodBeat.o(101135);
    }

    public final String className() {
        return "navsns.RttRequest";
    }

    public final String fullClassName() {
        return "navsns.RttRequest";
    }

    public final ArrayList<Integer> getBounds() {
        return this.bounds;
    }

    public final void setBounds(ArrayList<Integer> arrayList) {
        this.bounds = arrayList;
    }

    public final short getZoom() {
        return this.zoom;
    }

    public final void setZoom(short s) {
        this.zoom = s;
    }

    public final short getZip() {
        return this.zip;
    }

    public final void setZip(short s) {
        this.zip = s;
    }

    public RttRequest(ArrayList<Integer> arrayList, short s, short s2) {
        this.bounds = arrayList;
        this.zoom = s;
        this.zip = s2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(101128);
        if (obj == null) {
            AppMethodBeat.o(101128);
            return false;
        }
        RttRequest rttRequest = (RttRequest) obj;
        if (n.a(this.bounds, rttRequest.bounds) && n.a(this.zoom, rttRequest.zoom) && n.a(this.zip, rttRequest.zip)) {
            AppMethodBeat.o(101128);
            return true;
        }
        AppMethodBeat.o(101128);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(101129);
        try {
            Exception exception = new Exception("Need define key first!");
            AppMethodBeat.o(101129);
            throw exception;
        } catch (Exception e) {
            AppMethodBeat.o(101129);
            return 0;
        }
    }

    public final Object clone() {
        AppMethodBeat.i(101130);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            if (!b) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(101130);
                throw assertionError;
            }
        }
        AppMethodBeat.o(101130);
        return obj;
    }

    public final void writeTo(l lVar) {
        AppMethodBeat.i(101131);
        lVar.a(this.bounds, 0);
        lVar.a(this.zoom, 1);
        lVar.a(this.zip, 2);
        AppMethodBeat.o(101131);
    }

    public final void readFrom(k kVar) {
        AppMethodBeat.i(101132);
        this.bounds = (ArrayList) kVar.a(a, 0, true);
        this.zoom = kVar.a(this.zoom, 1, true);
        this.zip = kVar.a(this.zip, 2, true);
        AppMethodBeat.o(101132);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        AppMethodBeat.i(101133);
        i iVar = new i(stringBuilder, i);
        iVar.a(this.bounds, "bounds");
        iVar.a(this.zoom, "zoom");
        iVar.a(this.zip, "zip");
        AppMethodBeat.o(101133);
    }

    public final void displaySimple(StringBuilder stringBuilder, int i) {
        AppMethodBeat.i(101134);
        i iVar = new i(stringBuilder, i);
        iVar.a(this.bounds, true);
        iVar.a(this.zoom, true);
        iVar.a(this.zip, false);
        AppMethodBeat.o(101134);
    }
}
