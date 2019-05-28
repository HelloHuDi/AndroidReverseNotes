package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import java.util.Arrays;

public class TbsCoreLoadStat {
    /* renamed from: d */
    private static TbsCoreLoadStat f16273d = null;
    public static volatile int mLoadErrorCode = -1;
    /* renamed from: a */
    private TbsSequenceQueue f16274a = null;
    /* renamed from: b */
    private boolean f16275b = false;
    /* renamed from: c */
    private final int f16276c = 3;

    public class TbsSequenceQueue {
        /* renamed from: b */
        private int f16278b;
        /* renamed from: c */
        private int f16279c;
        /* renamed from: d */
        private int[] f16280d;
        /* renamed from: e */
        private int f16281e;
        /* renamed from: f */
        private int f16282f;

        public TbsSequenceQueue() {
            AppMethodBeat.m2504i(64291);
            this.f16278b = 10;
            this.f16281e = 0;
            this.f16282f = 0;
            this.f16279c = this.f16278b;
            this.f16280d = new int[this.f16279c];
            AppMethodBeat.m2505o(64291);
        }

        public TbsSequenceQueue(int i, int i2) {
            AppMethodBeat.m2504i(64292);
            this.f16278b = 10;
            this.f16281e = 0;
            this.f16282f = 0;
            this.f16279c = i2;
            this.f16280d = new int[this.f16279c];
            this.f16280d[0] = i;
            this.f16282f++;
            AppMethodBeat.m2505o(64292);
        }

        public void add(int i) {
            AppMethodBeat.m2504i(64293);
            if (this.f16282f > this.f16279c - 1) {
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("sequeue is full");
                AppMethodBeat.m2505o(64293);
                throw indexOutOfBoundsException;
            }
            int[] iArr = this.f16280d;
            int i2 = this.f16282f;
            this.f16282f = i2 + 1;
            iArr[i2] = i;
            AppMethodBeat.m2505o(64293);
        }

        public void clear() {
            AppMethodBeat.m2504i(64296);
            Arrays.fill(this.f16280d, 0);
            this.f16281e = 0;
            this.f16282f = 0;
            AppMethodBeat.m2505o(64296);
        }

        public int element() {
            AppMethodBeat.m2504i(64295);
            if (empty()) {
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("sequeue is null");
                AppMethodBeat.m2505o(64295);
                throw indexOutOfBoundsException;
            }
            int i = this.f16280d[this.f16281e];
            AppMethodBeat.m2505o(64295);
            return i;
        }

        public boolean empty() {
            return this.f16282f == this.f16281e;
        }

        public int length() {
            return this.f16282f - this.f16281e;
        }

        public int remove() {
            AppMethodBeat.m2504i(64294);
            if (empty()) {
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("sequeue is null");
                AppMethodBeat.m2505o(64294);
                throw indexOutOfBoundsException;
            }
            int i = this.f16280d[this.f16281e];
            int[] iArr = this.f16280d;
            int i2 = this.f16281e;
            this.f16281e = i2 + 1;
            iArr[i2] = 0;
            AppMethodBeat.m2505o(64294);
            return i;
        }

        public String toString() {
            AppMethodBeat.m2504i(64297);
            String str;
            if (empty()) {
                str = "";
                AppMethodBeat.m2505o(64297);
                return str;
            }
            int i;
            StringBuilder stringBuilder = new StringBuilder("[");
            for (i = this.f16281e; i < this.f16282f; i++) {
                stringBuilder.append(String.valueOf(this.f16280d[i]) + ",");
            }
            i = stringBuilder.length();
            str = stringBuilder.delete(i - 1, i).append("]").toString();
            AppMethodBeat.m2505o(64297);
            return str;
        }
    }

    private TbsCoreLoadStat() {
    }

    public static TbsCoreLoadStat getInstance() {
        AppMethodBeat.m2504i(64298);
        if (f16273d == null) {
            f16273d = new TbsCoreLoadStat();
        }
        TbsCoreLoadStat tbsCoreLoadStat = f16273d;
        AppMethodBeat.m2505o(64298);
        return tbsCoreLoadStat;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo64870a() {
        AppMethodBeat.m2504i(64299);
        if (this.f16274a != null) {
            this.f16274a.clear();
        }
        this.f16275b = false;
        AppMethodBeat.m2505o(64299);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo64871a(Context context, int i) {
        AppMethodBeat.m2504i(64300);
        mo64872a(context, i, null);
        TbsLog.m80432e(TbsListener.tag_load_error, String.valueOf(i));
        AppMethodBeat.m2505o(64300);
    }

    /* Access modifiers changed, original: declared_synchronized */
    /* renamed from: a */
    public synchronized void mo64872a(Context context, int i, Throwable th) {
        AppMethodBeat.m2504i(64301);
        if (mLoadErrorCode == -1) {
            mLoadErrorCode = i;
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR, "code=%d,desc=%s", Integer.valueOf(i), String.valueOf(th));
            if (th != null) {
                TbsLogReport.getInstance(context).setLoadErrorCode(i, th);
                AppMethodBeat.m2505o(64301);
            } else {
                TbsLog.m80432e("TbsCoreLoadStat", "setLoadErrorCode :: error is null with errorCode: " + i + "; Check & correct it!");
                AppMethodBeat.m2505o(64301);
            }
        } else {
            StringBuilder stringBuilder = new StringBuilder("setLoadErrorCode :: error(");
            stringBuilder.append(mLoadErrorCode);
            stringBuilder.append(") was already reported; ");
            stringBuilder.append(i);
            stringBuilder.append(" is duplicated. Try to remove it!");
            TbsLog.m80438w("TbsCoreLoadStat", stringBuilder.toString());
            AppMethodBeat.m2505o(64301);
        }
    }
}
