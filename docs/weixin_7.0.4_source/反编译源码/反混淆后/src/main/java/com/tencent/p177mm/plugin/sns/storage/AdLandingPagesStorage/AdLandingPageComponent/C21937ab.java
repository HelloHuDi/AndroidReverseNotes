package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab */
public final class C21937ab extends C29086r {
    public float borderWidth;
    public List<C21938a> itemList = new ArrayList();
    public int qXA;
    public int qXB;
    public int qXC;
    public String qXD = "";
    public String qXx = "";
    public String qXy = "";
    public int qXz;

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab$a */
    public static class C21938a {
        public String label = "";
        public String qXE = "";
        public float value;

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(36947);
            if (obj == this) {
                AppMethodBeat.m2505o(36947);
                return true;
            } else if (obj instanceof C21938a) {
                C21938a c21938a = (C21938a) obj;
                if (c21938a.label.equals(this.label) && c21938a.qXE.equals(this.qXE) && c21938a.value == this.value) {
                    AppMethodBeat.m2505o(36947);
                    return true;
                }
                AppMethodBeat.m2505o(36947);
                return false;
            } else {
                AppMethodBeat.m2505o(36947);
                return false;
            }
        }

        public final int hashCode() {
            AppMethodBeat.m2504i(36948);
            int hashCode = (int) (((float) (this.label.hashCode() + this.qXE.hashCode())) + this.value);
            AppMethodBeat.m2505o(36948);
            return hashCode;
        }
    }

    public C21937ab() {
        AppMethodBeat.m2504i(36949);
        AppMethodBeat.m2505o(36949);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(36950);
        if (obj == this) {
            AppMethodBeat.m2505o(36950);
            return true;
        } else if (obj instanceof C21937ab) {
            C21937ab c21937ab = (C21937ab) obj;
            if (c21937ab.qXx != null ? c21937ab.qXx.equals(this.qXx) : this.qXx == null) {
                if (c21937ab.borderWidth == this.borderWidth && (c21937ab.qXy != null ? !c21937ab.qXy.equals(this.qXy) : this.qXy != null) && c21937ab.qXz == this.qXz && c21937ab.qXA == this.qXA && c21937ab.qXB == this.qXB && c21937ab.qXC == this.qXC && (c21937ab.itemList != null ? !c21937ab.itemList.equals(this.itemList) : this.itemList != null) && (c21937ab.qXD != null ? !c21937ab.qXD.equals(this.qXD) : this.qXD != null)) {
                    AppMethodBeat.m2505o(36950);
                    return true;
                }
            }
            AppMethodBeat.m2505o(36950);
            return false;
        } else {
            AppMethodBeat.m2505o(36950);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(36951);
        int hashCode = super.hashCode();
        AppMethodBeat.m2505o(36951);
        return hashCode;
    }
}
