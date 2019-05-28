package navsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C16278i;
import com.tencent.tencentmap.mapsdk.maps.p667a.C24398l;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31070k;
import com.tencent.tencentmap.mapsdk.maps.p667a.C41080n;
import com.tencent.tencentmap.mapsdk.maps.p667a.C46803m;
import java.util.ArrayList;

public final class RttRequest extends C46803m implements Cloneable {
    /* renamed from: a */
    static ArrayList<Integer> f17542a = new ArrayList();
    /* renamed from: b */
    static final /* synthetic */ boolean f17543b;
    public ArrayList<Integer> bounds = null;
    public short zip = (short) 0;
    public short zoom = (short) 0;

    static {
        boolean z;
        AppMethodBeat.m2504i(101135);
        if (RttRequest.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        f17543b = z;
        f17542a.add(Integer.valueOf(0));
        AppMethodBeat.m2505o(101135);
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
        AppMethodBeat.m2504i(101128);
        if (obj == null) {
            AppMethodBeat.m2505o(101128);
            return false;
        }
        RttRequest rttRequest = (RttRequest) obj;
        if (C41080n.m71483a(this.bounds, rttRequest.bounds) && C41080n.m71484a(this.zoom, rttRequest.zoom) && C41080n.m71484a(this.zip, rttRequest.zip)) {
            AppMethodBeat.m2505o(101128);
            return true;
        }
        AppMethodBeat.m2505o(101128);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(101129);
        try {
            Exception exception = new Exception("Need define key first!");
            AppMethodBeat.m2505o(101129);
            throw exception;
        } catch (Exception e) {
            AppMethodBeat.m2505o(101129);
            return 0;
        }
    }

    public final Object clone() {
        AppMethodBeat.m2504i(101130);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            if (!f17543b) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.m2505o(101130);
                throw assertionError;
            }
        }
        AppMethodBeat.m2505o(101130);
        return obj;
    }

    public final void writeTo(C24398l c24398l) {
        AppMethodBeat.m2504i(101131);
        c24398l.mo40673a(this.bounds, 0);
        c24398l.mo40675a(this.zoom, 1);
        c24398l.mo40675a(this.zip, 2);
        AppMethodBeat.m2505o(101131);
    }

    public final void readFrom(C31070k c31070k) {
        AppMethodBeat.m2504i(101132);
        this.bounds = (ArrayList) c31070k.mo50507a(f17542a, 0, true);
        this.zoom = c31070k.mo50511a(this.zoom, 1, true);
        this.zip = c31070k.mo50511a(this.zip, 2, true);
        AppMethodBeat.m2505o(101132);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        AppMethodBeat.m2504i(101133);
        C16278i c16278i = new C16278i(stringBuilder, i);
        c16278i.mo29479a(this.bounds, "bounds");
        c16278i.mo29483a(this.zoom, "zoom");
        c16278i.mo29483a(this.zip, "zip");
        AppMethodBeat.m2505o(101133);
    }

    public final void displaySimple(StringBuilder stringBuilder, int i) {
        AppMethodBeat.m2504i(101134);
        C16278i c16278i = new C16278i(stringBuilder, i);
        c16278i.mo29480a(this.bounds, true);
        c16278i.mo29484a(this.zoom, true);
        c16278i.mo29484a(this.zip, false);
        AppMethodBeat.m2505o(101134);
    }
}
