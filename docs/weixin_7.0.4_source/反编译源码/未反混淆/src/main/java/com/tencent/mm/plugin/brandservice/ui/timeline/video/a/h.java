package com.tencent.mm.plugin.brandservice.ui.timeline.video.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/VideoPlayTime;", "", "saveTime", "", "playTime", "", "(JD)V", "getPlayTime", "()D", "getSaveTime", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-brandservice_release"})
public final class h {
    final long jYX;
    final double jYY;

    /* JADX WARNING: Missing block: B:9:0x0022, code skipped:
            if (java.lang.Double.compare(r7.jYY, r8.jYY) == 0) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.i(15347);
        if (this != obj) {
            if (obj instanceof h) {
                h hVar = (h) obj;
                if (this.jYX == hVar.jYX) {
                }
            }
            AppMethodBeat.o(15347);
            return false;
        }
        AppMethodBeat.o(15347);
        return true;
    }

    public final int hashCode() {
        AppMethodBeat.i(15346);
        long j = this.jYX;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        long doubleToLongBits = Double.doubleToLongBits(this.jYY);
        i += (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        AppMethodBeat.o(15346);
        return i;
    }

    public final String toString() {
        AppMethodBeat.i(15345);
        String str = "VideoPlayTime(saveTime=" + this.jYX + ", playTime=" + this.jYY + ")";
        AppMethodBeat.o(15345);
        return str;
    }

    public h(long j, double d) {
        this.jYX = j;
        this.jYY = d;
    }
}
