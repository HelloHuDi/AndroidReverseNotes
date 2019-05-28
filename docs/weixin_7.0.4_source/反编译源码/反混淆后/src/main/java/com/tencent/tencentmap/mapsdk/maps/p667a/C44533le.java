package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C24333as;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.le */
public interface C44533le extends C24333as {

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.le$b */
    public enum C36531b {
        LEFT_BOTTOM(0),
        CENTER_BOTTOM(4),
        RIGHT_BOTTOM(1),
        LEFT_TOP(3),
        CENTER_TOP(5),
        RIGHT_TOP(2);
        
        /* renamed from: g */
        public final int f15446g;

        static {
            AppMethodBeat.m2505o(100334);
        }

        private C36531b(int i) {
            this.f15446g = i;
        }

        /* renamed from: a */
        public static C36531b m60522a(int i) {
            AppMethodBeat.m2504i(100333);
            if (i < 0 || i >= C36531b.values().length) {
                i = 0;
            }
            C36531b c36531b = LEFT_BOTTOM;
            for (C36531b c36531b2 : C36531b.values()) {
                if (c36531b2.f15446g == i) {
                    break;
                }
            }
            C36531b c36531b22 = c36531b;
            AppMethodBeat.m2505o(100333);
            return c36531b22;
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.le$a */
    public enum C41072a {
        LEFT(0),
        RIGHT(1),
        BOTTOM(2),
        TOP(3);
        
        /* renamed from: e */
        public int f16539e;

        static {
            AppMethodBeat.m2505o(100330);
        }

        private C41072a(int i) {
            this.f16539e = i;
        }
    }

    /* renamed from: a */
    void mo40698a();

    /* renamed from: a */
    boolean mo40708a(ViewGroup viewGroup);
}
