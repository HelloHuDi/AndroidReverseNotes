package com.tencent.p177mm.media.widget.camerarecordview.p258a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000e¨\u0006\u001a"}, dWq = {"Lcom/tencent/mm/media/widget/camerarecordview/data/CameraCaptureInfo;", "", "recordVideo", "", "recordThumb", "isCaptureVideo", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "()Z", "setCaptureVideo", "(Z)V", "getRecordThumb", "()Ljava/lang/String;", "setRecordThumb", "(Ljava/lang/String;)V", "getRecordVideo", "setRecordVideo", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.widget.camerarecordview.a.a */
public final class C9614a {
    public String fbT;
    public String fbU;
    public boolean fbV = true;

    /* JADX WARNING: Missing block: B:11:0x002a, code skipped:
            if ((r5.fbV == r6.fbV) != false) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(13260);
        if (this != obj) {
            if (obj instanceof C9614a) {
                C9614a c9614a = (C9614a) obj;
                if (C25052j.m39373j(this.fbT, c9614a.fbT) && C25052j.m39373j(this.fbU, c9614a.fbU)) {
                }
            }
            AppMethodBeat.m2505o(13260);
            return false;
        }
        AppMethodBeat.m2505o(13260);
        return true;
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.m2504i(13259);
        String str = this.fbT;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.fbU;
        if (str2 != null) {
            i = str2.hashCode();
        }
        i = (hashCode + i) * 31;
        hashCode = this.fbV;
        if (hashCode != 0) {
            hashCode = 1;
        }
        hashCode += i;
        AppMethodBeat.m2505o(13259);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.m2504i(13258);
        String str = "CameraCaptureInfo(recordVideo=" + this.fbT + ", recordThumb=" + this.fbU + ", isCaptureVideo=" + this.fbV + ")";
        AppMethodBeat.m2505o(13258);
        return str;
    }

    public C9614a(String str, String str2) {
        C25052j.m39376p(str, "recordVideo");
        C25052j.m39376p(str2, "recordThumb");
        AppMethodBeat.m2504i(13257);
        this.fbT = str;
        this.fbU = str2;
        AppMethodBeat.m2505o(13257);
    }
}
