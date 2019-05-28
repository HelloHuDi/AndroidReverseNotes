package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import java.util.Arrays;

public class TbsCoreLoadStat {
    private static TbsCoreLoadStat d = null;
    public static volatile int mLoadErrorCode = -1;
    private TbsSequenceQueue a = null;
    private boolean b = false;
    private final int c = 3;

    public class TbsSequenceQueue {
        private int b;
        private int c;
        private int[] d;
        private int e;
        private int f;

        public TbsSequenceQueue() {
            AppMethodBeat.i(64291);
            this.b = 10;
            this.e = 0;
            this.f = 0;
            this.c = this.b;
            this.d = new int[this.c];
            AppMethodBeat.o(64291);
        }

        public TbsSequenceQueue(int i, int i2) {
            AppMethodBeat.i(64292);
            this.b = 10;
            this.e = 0;
            this.f = 0;
            this.c = i2;
            this.d = new int[this.c];
            this.d[0] = i;
            this.f++;
            AppMethodBeat.o(64292);
        }

        public void add(int i) {
            AppMethodBeat.i(64293);
            if (this.f > this.c - 1) {
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("sequeue is full");
                AppMethodBeat.o(64293);
                throw indexOutOfBoundsException;
            }
            int[] iArr = this.d;
            int i2 = this.f;
            this.f = i2 + 1;
            iArr[i2] = i;
            AppMethodBeat.o(64293);
        }

        public void clear() {
            AppMethodBeat.i(64296);
            Arrays.fill(this.d, 0);
            this.e = 0;
            this.f = 0;
            AppMethodBeat.o(64296);
        }

        public int element() {
            AppMethodBeat.i(64295);
            if (empty()) {
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("sequeue is null");
                AppMethodBeat.o(64295);
                throw indexOutOfBoundsException;
            }
            int i = this.d[this.e];
            AppMethodBeat.o(64295);
            return i;
        }

        public boolean empty() {
            return this.f == this.e;
        }

        public int length() {
            return this.f - this.e;
        }

        public int remove() {
            AppMethodBeat.i(64294);
            if (empty()) {
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("sequeue is null");
                AppMethodBeat.o(64294);
                throw indexOutOfBoundsException;
            }
            int i = this.d[this.e];
            int[] iArr = this.d;
            int i2 = this.e;
            this.e = i2 + 1;
            iArr[i2] = 0;
            AppMethodBeat.o(64294);
            return i;
        }

        public String toString() {
            AppMethodBeat.i(64297);
            String str;
            if (empty()) {
                str = "";
                AppMethodBeat.o(64297);
                return str;
            }
            int i;
            StringBuilder stringBuilder = new StringBuilder("[");
            for (i = this.e; i < this.f; i++) {
                stringBuilder.append(String.valueOf(this.d[i]) + ",");
            }
            i = stringBuilder.length();
            str = stringBuilder.delete(i - 1, i).append("]").toString();
            AppMethodBeat.o(64297);
            return str;
        }
    }

    private TbsCoreLoadStat() {
    }

    public static TbsCoreLoadStat getInstance() {
        AppMethodBeat.i(64298);
        if (d == null) {
            d = new TbsCoreLoadStat();
        }
        TbsCoreLoadStat tbsCoreLoadStat = d;
        AppMethodBeat.o(64298);
        return tbsCoreLoadStat;
    }

    /* Access modifiers changed, original: 0000 */
    public void a() {
        AppMethodBeat.i(64299);
        if (this.a != null) {
            this.a.clear();
        }
        this.b = false;
        AppMethodBeat.o(64299);
    }

    /* Access modifiers changed, original: 0000 */
    public void a(Context context, int i) {
        AppMethodBeat.i(64300);
        a(context, i, null);
        TbsLog.e(TbsListener.tag_load_error, String.valueOf(i));
        AppMethodBeat.o(64300);
    }

    /* Access modifiers changed, original: declared_synchronized */
    public synchronized void a(Context context, int i, Throwable th) {
        AppMethodBeat.i(64301);
        if (mLoadErrorCode == -1) {
            mLoadErrorCode = i;
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR, "code=%d,desc=%s", Integer.valueOf(i), String.valueOf(th));
            if (th != null) {
                TbsLogReport.getInstance(context).setLoadErrorCode(i, th);
                AppMethodBeat.o(64301);
            } else {
                TbsLog.e("TbsCoreLoadStat", "setLoadErrorCode :: error is null with errorCode: " + i + "; Check & correct it!");
                AppMethodBeat.o(64301);
            }
        } else {
            StringBuilder stringBuilder = new StringBuilder("setLoadErrorCode :: error(");
            stringBuilder.append(mLoadErrorCode);
            stringBuilder.append(") was already reported; ");
            stringBuilder.append(i);
            stringBuilder.append(" is duplicated. Try to remove it!");
            TbsLog.w("TbsCoreLoadStat", stringBuilder.toString());
            AppMethodBeat.o(64301);
        }
    }
}
