package com.bumptech.glide.c.b;

import com.bumptech.glide.c.a;
import com.bumptech.glide.c.c;

public abstract class i {
    public static final i aBi = new i() {
        public final boolean a(a aVar) {
            return aVar == a.REMOTE;
        }

        public final boolean a(boolean z, a aVar, c cVar) {
            return (aVar == a.RESOURCE_DISK_CACHE || aVar == a.MEMORY_CACHE) ? false : true;
        }

        public final boolean mE() {
            return true;
        }

        public final boolean mF() {
            return true;
        }
    };
    public static final i aBj = new i() {
        public final boolean a(a aVar) {
            return false;
        }

        public final boolean a(boolean z, a aVar, c cVar) {
            return false;
        }

        public final boolean mE() {
            return false;
        }

        public final boolean mF() {
            return false;
        }
    };
    public static final i aBk = new i() {
        public final boolean a(a aVar) {
            return (aVar == a.DATA_DISK_CACHE || aVar == a.MEMORY_CACHE) ? false : true;
        }

        public final boolean a(boolean z, a aVar, c cVar) {
            return false;
        }

        public final boolean mE() {
            return false;
        }

        public final boolean mF() {
            return true;
        }
    };
    public static final i aBl = new i() {
        public final boolean a(a aVar) {
            return false;
        }

        public final boolean a(boolean z, a aVar, c cVar) {
            return (aVar == a.RESOURCE_DISK_CACHE || aVar == a.MEMORY_CACHE) ? false : true;
        }

        public final boolean mE() {
            return true;
        }

        public final boolean mF() {
            return false;
        }
    };
    public static final i aBm = new i() {
        public final boolean a(a aVar) {
            return aVar == a.REMOTE;
        }

        public final boolean a(boolean z, a aVar, c cVar) {
            return ((z && aVar == a.DATA_DISK_CACHE) || aVar == a.LOCAL) && cVar == c.TRANSFORMED;
        }

        public final boolean mE() {
            return true;
        }

        public final boolean mF() {
            return true;
        }
    };

    public abstract boolean a(a aVar);

    public abstract boolean a(boolean z, a aVar, c cVar);

    public abstract boolean mE();

    public abstract boolean mF();
}
