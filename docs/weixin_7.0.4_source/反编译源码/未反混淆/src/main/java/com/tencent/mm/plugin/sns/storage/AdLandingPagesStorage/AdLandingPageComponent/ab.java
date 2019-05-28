package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class ab extends r {
    public float borderWidth;
    public List<a> itemList = new ArrayList();
    public int qXA;
    public int qXB;
    public int qXC;
    public String qXD = "";
    public String qXx = "";
    public String qXy = "";
    public int qXz;

    public static class a {
        public String label = "";
        public String qXE = "";
        public float value;

        public final boolean equals(Object obj) {
            AppMethodBeat.i(36947);
            if (obj == this) {
                AppMethodBeat.o(36947);
                return true;
            } else if (obj instanceof a) {
                a aVar = (a) obj;
                if (aVar.label.equals(this.label) && aVar.qXE.equals(this.qXE) && aVar.value == this.value) {
                    AppMethodBeat.o(36947);
                    return true;
                }
                AppMethodBeat.o(36947);
                return false;
            } else {
                AppMethodBeat.o(36947);
                return false;
            }
        }

        public final int hashCode() {
            AppMethodBeat.i(36948);
            int hashCode = (int) (((float) (this.label.hashCode() + this.qXE.hashCode())) + this.value);
            AppMethodBeat.o(36948);
            return hashCode;
        }
    }

    public ab() {
        AppMethodBeat.i(36949);
        AppMethodBeat.o(36949);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(36950);
        if (obj == this) {
            AppMethodBeat.o(36950);
            return true;
        } else if (obj instanceof ab) {
            ab abVar = (ab) obj;
            if (abVar.qXx != null ? abVar.qXx.equals(this.qXx) : this.qXx == null) {
                if (abVar.borderWidth == this.borderWidth && (abVar.qXy != null ? !abVar.qXy.equals(this.qXy) : this.qXy != null) && abVar.qXz == this.qXz && abVar.qXA == this.qXA && abVar.qXB == this.qXB && abVar.qXC == this.qXC && (abVar.itemList != null ? !abVar.itemList.equals(this.itemList) : this.itemList != null) && (abVar.qXD != null ? !abVar.qXD.equals(this.qXD) : this.qXD != null)) {
                    AppMethodBeat.o(36950);
                    return true;
                }
            }
            AppMethodBeat.o(36950);
            return false;
        } else {
            AppMethodBeat.o(36950);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(36951);
        int hashCode = super.hashCode();
        AppMethodBeat.o(36951);
        return hashCode;
    }
}
