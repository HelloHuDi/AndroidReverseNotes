package com.tencent.smtt.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UnknownFormatConversionException;

public class j implements Closeable {
    static final char[] a = new char[]{127, 'E', 'L', 'F', 0};
    final char[] b = new char[16];
    boolean c;
    j[] d;
    l[] e;
    byte[] f;
    private final c g;
    private final a h;
    private final k[] i;
    private byte[] j;

    public static abstract class a {
        short a;
        short b;
        int c;
        int d;
        short e;
        short f;
        short g;
        short h;
        short i;
        short j;

        public abstract long a();

        public abstract long b();
    }

    static class d extends k {
        int a;
        int b;
        int c;
        int d;
        int e;
        int f;

        d() {
        }

        public int a() {
            return this.d;
        }

        public long b() {
            return (long) this.c;
        }
    }

    static abstract class j {
        int g;
        int h;

        j() {
        }
    }

    static abstract class l {
        int c;
        char d;
        char e;
        short f;

        l() {
        }
    }

    static class i extends l {
        long a;
        long b;

        i() {
        }
    }

    static class b extends a {
        int k;
        int l;
        int m;

        b() {
        }

        /* Access modifiers changed, original: 0000 */
        public long a() {
            return (long) this.m;
        }

        /* Access modifiers changed, original: 0000 */
        public long b() {
            return (long) this.l;
        }
    }

    static class c extends j {
        int a;
        int b;
        int c;
        int d;
        int e;
        int f;

        c() {
        }
    }

    public static abstract class k {
        int g;
        int h;
        int i;
        int j;

        public abstract int a();

        public abstract long b();
    }

    static class f extends a {
        long k;
        long l;
        long m;

        f() {
        }

        /* Access modifiers changed, original: 0000 */
        public long a() {
            return this.m;
        }

        /* Access modifiers changed, original: 0000 */
        public long b() {
            return this.l;
        }
    }

    static class h extends k {
        long a;
        long b;
        long c;
        long d;
        long e;
        long f;

        h() {
        }

        public int a() {
            return (int) this.d;
        }

        public long b() {
            return this.c;
        }
    }

    static class e extends l {
        int a;
        int b;

        e() {
        }
    }

    static class g extends j {
        long a;
        long b;
        long c;
        long d;
        long e;
        long f;

        g() {
        }
    }

    public j(File file) {
        AppMethodBeat.i(65211);
        c cVar = new c(file);
        this.g = cVar;
        cVar.a(this.b);
        UnknownFormatConversionException unknownFormatConversionException;
        if (a()) {
            cVar.a(e());
            boolean d = d();
            if (d) {
                f fVar = new f();
                fVar.a = cVar.a();
                fVar.b = cVar.a();
                fVar.c = cVar.b();
                fVar.k = cVar.c();
                fVar.l = cVar.c();
                fVar.m = cVar.c();
                this.h = fVar;
            } else {
                b bVar = new b();
                bVar.a = cVar.a();
                bVar.b = cVar.a();
                bVar.c = cVar.b();
                bVar.k = cVar.b();
                bVar.l = cVar.b();
                bVar.m = cVar.b();
                this.h = bVar;
            }
            a aVar = this.h;
            aVar.d = cVar.b();
            aVar.e = cVar.a();
            aVar.f = cVar.a();
            aVar.g = cVar.a();
            aVar.h = cVar.a();
            aVar.i = cVar.a();
            aVar.j = cVar.a();
            this.i = new k[aVar.i];
            for (short s = (short) 0; s < aVar.i; s++) {
                cVar.a(aVar.a() + ((long) (aVar.h * s)));
                if (d) {
                    h hVar = new h();
                    hVar.g = cVar.b();
                    hVar.h = cVar.b();
                    hVar.a = cVar.c();
                    hVar.b = cVar.c();
                    hVar.c = cVar.c();
                    hVar.d = cVar.c();
                    hVar.i = cVar.b();
                    hVar.j = cVar.b();
                    hVar.e = cVar.c();
                    hVar.f = cVar.c();
                    this.i[s] = hVar;
                } else {
                    d dVar = new d();
                    dVar.g = cVar.b();
                    dVar.h = cVar.b();
                    dVar.a = cVar.b();
                    dVar.b = cVar.b();
                    dVar.c = cVar.b();
                    dVar.d = cVar.b();
                    dVar.i = cVar.b();
                    dVar.j = cVar.b();
                    dVar.e = cVar.b();
                    dVar.f = cVar.b();
                    this.i[s] = dVar;
                }
            }
            if (aVar.j < (short) 0 || aVar.j >= this.i.length) {
                unknownFormatConversionException = new UnknownFormatConversionException("Invalid e_shstrndx=" + aVar.j);
                AppMethodBeat.o(65211);
                throw unknownFormatConversionException;
            }
            k kVar = this.i[aVar.j];
            if (kVar.h == 3) {
                this.j = new byte[kVar.a()];
                cVar.a(kVar.b());
                cVar.a(this.j);
                if (this.c) {
                    f();
                }
                AppMethodBeat.o(65211);
                return;
            }
            unknownFormatConversionException = new UnknownFormatConversionException("Wrong string section e_shstrndx=" + aVar.j);
            AppMethodBeat.o(65211);
            throw unknownFormatConversionException;
        }
        unknownFormatConversionException = new UnknownFormatConversionException("Invalid elf magic: ".concat(String.valueOf(file)));
        AppMethodBeat.o(65211);
        throw unknownFormatConversionException;
    }

    public static boolean a(File file) {
        AppMethodBeat.i(65216);
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            long readInt = (long) randomAccessFile.readInt();
            randomAccessFile.close();
            if (readInt == 2135247942) {
                AppMethodBeat.o(65216);
                return true;
            }
            AppMethodBeat.o(65216);
            return false;
        } catch (Throwable th) {
            AppMethodBeat.o(65216);
            return false;
        }
    }

    public static boolean b(File file) {
        AppMethodBeat.i(65217);
        if (g() && a(file)) {
            try {
                j jVar = new j(file);
            } catch (IOException e) {
                new StringBuilder("checkElfFile IOException: ").append(e);
                AppMethodBeat.o(65217);
                return false;
            } catch (UnknownFormatConversionException e2) {
                new StringBuilder("checkElfFile UnknownFormatConversionException: ").append(e2);
            } catch (Throwable th) {
                new StringBuilder("checkElfFile Throwable: ").append(th);
            }
        }
        AppMethodBeat.o(65217);
        return true;
    }

    private void f() {
        AppMethodBeat.i(65212);
        a aVar = this.h;
        c cVar = this.g;
        boolean d = d();
        k a = a(".dynsym");
        if (a != null) {
            cVar.a(a.b());
            int a2 = a.a() / (d ? 24 : 16);
            this.e = new l[a2];
            char[] cArr = new char[1];
            for (int i = 0; i < a2; i++) {
                if (d) {
                    i iVar = new i();
                    iVar.c = cVar.b();
                    cVar.a(cArr);
                    iVar.d = cArr[0];
                    cVar.a(cArr);
                    iVar.e = cArr[0];
                    iVar.a = cVar.c();
                    iVar.b = cVar.c();
                    iVar.f = cVar.a();
                    this.e[i] = iVar;
                } else {
                    e eVar = new e();
                    eVar.c = cVar.b();
                    eVar.a = cVar.b();
                    eVar.b = cVar.b();
                    cVar.a(cArr);
                    eVar.d = cArr[0];
                    cVar.a(cArr);
                    eVar.e = cArr[0];
                    eVar.f = cVar.a();
                    this.e[i] = eVar;
                }
            }
            k kVar = this.i[a.i];
            cVar.a(kVar.b());
            this.f = new byte[kVar.a()];
            cVar.a(this.f);
        }
        this.d = new j[aVar.g];
        for (short s = (short) 0; s < aVar.g; s++) {
            cVar.a(aVar.b() + ((long) (aVar.f * s)));
            if (d) {
                g gVar = new g();
                gVar.g = cVar.b();
                gVar.h = cVar.b();
                gVar.a = cVar.c();
                gVar.b = cVar.c();
                gVar.c = cVar.c();
                gVar.d = cVar.c();
                gVar.e = cVar.c();
                gVar.f = cVar.c();
                this.d[s] = gVar;
            } else {
                c cVar2 = new c();
                cVar2.g = cVar.b();
                cVar2.h = cVar.b();
                cVar2.a = cVar.b();
                cVar2.b = cVar.b();
                cVar2.c = cVar.b();
                cVar2.d = cVar.b();
                cVar2.e = cVar.b();
                cVar2.f = cVar.b();
                this.d[s] = cVar2;
            }
        }
        AppMethodBeat.o(65212);
    }

    private static boolean g() {
        AppMethodBeat.i(65218);
        String property = System.getProperty("java.vm.version");
        if (property == null || !property.startsWith("2")) {
            AppMethodBeat.o(65218);
            return false;
        }
        AppMethodBeat.o(65218);
        return true;
    }

    public final k a(String str) {
        AppMethodBeat.i(65213);
        for (k kVar : this.i) {
            if (str.equals(a(kVar.g))) {
                AppMethodBeat.o(65213);
                return kVar;
            }
        }
        AppMethodBeat.o(65213);
        return null;
    }

    public final String a(int i) {
        AppMethodBeat.i(65214);
        if (i == 0) {
            String str = "SHN_UNDEF";
            AppMethodBeat.o(65214);
            return str;
        }
        int i2 = i;
        while (this.j[i2] != (byte) 0) {
            i2++;
        }
        String str2 = new String(this.j, i, i2 - i);
        AppMethodBeat.o(65214);
        return str2;
    }

    /* Access modifiers changed, original: final */
    public final boolean a() {
        return this.b[0] == a[0];
    }

    /* Access modifiers changed, original: final */
    public final char b() {
        return this.b[4];
    }

    /* Access modifiers changed, original: final */
    public final char c() {
        return this.b[5];
    }

    public void close() {
        AppMethodBeat.i(65215);
        this.g.close();
        AppMethodBeat.o(65215);
    }

    public final boolean d() {
        AppMethodBeat.i(65209);
        if (b() == 2) {
            AppMethodBeat.o(65209);
            return true;
        }
        AppMethodBeat.o(65209);
        return false;
    }

    public final boolean e() {
        AppMethodBeat.i(65210);
        if (c() == 1) {
            AppMethodBeat.o(65210);
            return true;
        }
        AppMethodBeat.o(65210);
        return false;
    }
}
