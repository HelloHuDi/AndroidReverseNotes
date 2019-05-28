package com.tencent.mm.media.f;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/media/mix/FrameInfo;", "", "bitmap", "Landroid/graphics/Bitmap;", "frameDuration", "", "(Landroid/graphics/Bitmap;J)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getFrameDuration", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-mediaeditor_release"})
public final class c {
    public final Bitmap bitmap;
    public final long eWH;

    /* JADX WARNING: Missing block: B:9:0x0022, code skipped:
            if ((r7.eWH == r8.eWH) != false) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.i(12995);
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (j.j(this.bitmap, cVar.bitmap)) {
                }
            }
            AppMethodBeat.o(12995);
            return false;
        }
        AppMethodBeat.o(12995);
        return true;
    }

    public final int hashCode() {
        AppMethodBeat.i(12994);
        Bitmap bitmap = this.bitmap;
        int hashCode = (bitmap != null ? bitmap.hashCode() : 0) * 31;
        long j = this.eWH;
        hashCode += (int) (j ^ (j >>> 32));
        AppMethodBeat.o(12994);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(12993);
        String str = "FrameInfo(bitmap=" + this.bitmap + ", frameDuration=" + this.eWH + ")";
        AppMethodBeat.o(12993);
        return str;
    }

    public c(Bitmap bitmap, long j) {
        j.p(bitmap, "bitmap");
        AppMethodBeat.i(12992);
        this.bitmap = bitmap;
        this.eWH = j;
        AppMethodBeat.o(12992);
    }
}
