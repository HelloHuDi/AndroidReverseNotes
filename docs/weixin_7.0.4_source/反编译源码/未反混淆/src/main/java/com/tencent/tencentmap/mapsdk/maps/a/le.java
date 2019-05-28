package com.tencent.tencentmap.mapsdk.maps.a;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.as;

public interface le extends as {

    public enum b {
        LEFT_BOTTOM(0),
        CENTER_BOTTOM(4),
        RIGHT_BOTTOM(1),
        LEFT_TOP(3),
        CENTER_TOP(5),
        RIGHT_TOP(2);
        
        public final int g;

        static {
            AppMethodBeat.o(100334);
        }

        private b(int i) {
            this.g = i;
        }

        public static b a(int i) {
            AppMethodBeat.i(100333);
            if (i < 0 || i >= values().length) {
                i = 0;
            }
            b bVar = LEFT_BOTTOM;
            for (b bVar2 : values()) {
                if (bVar2.g == i) {
                    break;
                }
            }
            b bVar22 = bVar;
            AppMethodBeat.o(100333);
            return bVar22;
        }
    }

    public enum a {
        LEFT(0),
        RIGHT(1),
        BOTTOM(2),
        TOP(3);
        
        public int e;

        static {
            AppMethodBeat.o(100330);
        }

        private a(int i) {
            this.e = i;
        }
    }

    void a();

    boolean a(ViewGroup viewGroup);
}
