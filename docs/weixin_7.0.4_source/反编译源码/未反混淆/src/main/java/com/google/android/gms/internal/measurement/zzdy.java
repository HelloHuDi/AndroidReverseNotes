package com.google.android.gms.internal.measurement;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzdy {
    private final zzgl zzacw;
    private String zzadl;
    private String zzadm;
    private String zzadn;
    private String zzado;
    private long zzadp;
    private long zzadq;
    private long zzadr;
    private long zzads;
    private String zzadt;
    private long zzadu;
    private long zzadv;
    private boolean zzadw;
    private long zzadx;
    private boolean zzady;
    private boolean zzadz;
    private long zzaea;
    private long zzaeb;
    private long zzaec;
    private long zzaed;
    private long zzaee;
    private long zzaef;
    private String zzaeg;
    private boolean zzaeh;
    private long zzaei;
    private long zzaej;
    private String zzth;
    private final String zzti;

    zzdy(zzgl zzgl, String str) {
        AppMethodBeat.i(68525);
        Preconditions.checkNotNull(zzgl);
        Preconditions.checkNotEmpty(str);
        this.zzacw = zzgl;
        this.zzti = str;
        this.zzacw.zzab();
        AppMethodBeat.o(68525);
    }

    public final String getAppInstanceId() {
        AppMethodBeat.i(68528);
        this.zzacw.zzab();
        String str = this.zzadl;
        AppMethodBeat.o(68528);
        return str;
    }

    public final String getGmpAppId() {
        AppMethodBeat.i(68530);
        this.zzacw.zzab();
        String str = this.zzadm;
        AppMethodBeat.o(68530);
        return str;
    }

    public final boolean isMeasurementEnabled() {
        AppMethodBeat.i(68550);
        this.zzacw.zzab();
        boolean z = this.zzadw;
        AppMethodBeat.o(68550);
        return z;
    }

    public final void setAppVersion(String str) {
        AppMethodBeat.i(68541);
        this.zzacw.zzab();
        this.zzaeh = (!zzka.zzs(this.zzth, str) ? 1 : 0) | this.zzaeh;
        this.zzth = str;
        AppMethodBeat.o(68541);
    }

    public final void setMeasurementEnabled(boolean z) {
        AppMethodBeat.i(68551);
        this.zzacw.zzab();
        this.zzaeh = (this.zzadw != z ? 1 : 0) | this.zzaeh;
        this.zzadw = z;
        AppMethodBeat.o(68551);
    }

    public final void zzaa(long j) {
        AppMethodBeat.i(68575);
        this.zzacw.zzab();
        this.zzaeh = (this.zzadx != j ? 1 : 0) | this.zzaeh;
        this.zzadx = j;
        AppMethodBeat.o(68575);
    }

    public final String zzag() {
        AppMethodBeat.i(68540);
        this.zzacw.zzab();
        String str = this.zzth;
        AppMethodBeat.o(68540);
        return str;
    }

    public final String zzah() {
        AppMethodBeat.i(68527);
        this.zzacw.zzab();
        String str = this.zzti;
        AppMethodBeat.o(68527);
        return str;
    }

    public final void zzal(String str) {
        AppMethodBeat.i(68529);
        this.zzacw.zzab();
        this.zzaeh = (!zzka.zzs(this.zzadl, str) ? 1 : 0) | this.zzaeh;
        this.zzadl = str;
        AppMethodBeat.o(68529);
    }

    public final void zzam(String str) {
        AppMethodBeat.i(68531);
        this.zzacw.zzab();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzaeh = (!zzka.zzs(this.zzadm, str) ? 1 : 0) | this.zzaeh;
        this.zzadm = str;
        AppMethodBeat.o(68531);
    }

    public final void zzan(String str) {
        AppMethodBeat.i(68533);
        this.zzacw.zzab();
        this.zzaeh = (!zzka.zzs(this.zzadn, str) ? 1 : 0) | this.zzaeh;
        this.zzadn = str;
        AppMethodBeat.o(68533);
    }

    public final void zzao(String str) {
        AppMethodBeat.i(68535);
        this.zzacw.zzab();
        this.zzaeh = (!zzka.zzs(this.zzado, str) ? 1 : 0) | this.zzaeh;
        this.zzado = str;
        AppMethodBeat.o(68535);
    }

    public final void zzap(String str) {
        AppMethodBeat.i(68545);
        this.zzacw.zzab();
        this.zzaeh = (!zzka.zzs(this.zzadt, str) ? 1 : 0) | this.zzaeh;
        this.zzadt = str;
        AppMethodBeat.o(68545);
    }

    public final void zzaq(String str) {
        AppMethodBeat.i(68573);
        this.zzacw.zzab();
        this.zzaeh = (!zzka.zzs(this.zzaeg, str) ? 1 : 0) | this.zzaeh;
        this.zzaeg = str;
        AppMethodBeat.o(68573);
    }

    public final void zzd(boolean z) {
        AppMethodBeat.i(68577);
        this.zzacw.zzab();
        this.zzaeh = this.zzady != z;
        this.zzady = z;
        AppMethodBeat.o(68577);
    }

    public final void zze(boolean z) {
        AppMethodBeat.i(68579);
        this.zzacw.zzab();
        this.zzaeh = this.zzadz != z;
        this.zzadz = z;
        AppMethodBeat.o(68579);
    }

    public final void zzgh() {
        AppMethodBeat.i(68526);
        this.zzacw.zzab();
        this.zzaeh = false;
        AppMethodBeat.o(68526);
    }

    public final String zzgi() {
        AppMethodBeat.i(68532);
        this.zzacw.zzab();
        String str = this.zzadn;
        AppMethodBeat.o(68532);
        return str;
    }

    public final String zzgj() {
        AppMethodBeat.i(68534);
        this.zzacw.zzab();
        String str = this.zzado;
        AppMethodBeat.o(68534);
        return str;
    }

    public final long zzgk() {
        AppMethodBeat.i(68536);
        this.zzacw.zzab();
        long j = this.zzadq;
        AppMethodBeat.o(68536);
        return j;
    }

    public final long zzgl() {
        AppMethodBeat.i(68538);
        this.zzacw.zzab();
        long j = this.zzadr;
        AppMethodBeat.o(68538);
        return j;
    }

    public final long zzgm() {
        AppMethodBeat.i(68542);
        this.zzacw.zzab();
        long j = this.zzads;
        AppMethodBeat.o(68542);
        return j;
    }

    public final String zzgn() {
        AppMethodBeat.i(68544);
        this.zzacw.zzab();
        String str = this.zzadt;
        AppMethodBeat.o(68544);
        return str;
    }

    public final long zzgo() {
        AppMethodBeat.i(68546);
        this.zzacw.zzab();
        long j = this.zzadu;
        AppMethodBeat.o(68546);
        return j;
    }

    public final long zzgp() {
        AppMethodBeat.i(68548);
        this.zzacw.zzab();
        long j = this.zzadv;
        AppMethodBeat.o(68548);
        return j;
    }

    public final long zzgq() {
        AppMethodBeat.i(68553);
        this.zzacw.zzab();
        long j = this.zzadp;
        AppMethodBeat.o(68553);
        return j;
    }

    public final long zzgr() {
        AppMethodBeat.i(68554);
        this.zzacw.zzab();
        long j = this.zzaei;
        AppMethodBeat.o(68554);
        return j;
    }

    public final long zzgs() {
        AppMethodBeat.i(68556);
        this.zzacw.zzab();
        long j = this.zzaej;
        AppMethodBeat.o(68556);
        return j;
    }

    public final void zzgt() {
        AppMethodBeat.i(68558);
        this.zzacw.zzab();
        long j = this.zzadp + 1;
        if (j > 2147483647L) {
            this.zzacw.zzge().zzip().zzg("Bundle index overflow. appId", zzfg.zzbm(this.zzti));
            j = 0;
        }
        this.zzaeh = true;
        this.zzadp = j;
        AppMethodBeat.o(68558);
    }

    public final long zzgu() {
        AppMethodBeat.i(68559);
        this.zzacw.zzab();
        long j = this.zzaea;
        AppMethodBeat.o(68559);
        return j;
    }

    public final long zzgv() {
        AppMethodBeat.i(68561);
        this.zzacw.zzab();
        long j = this.zzaeb;
        AppMethodBeat.o(68561);
        return j;
    }

    public final long zzgw() {
        AppMethodBeat.i(68563);
        this.zzacw.zzab();
        long j = this.zzaec;
        AppMethodBeat.o(68563);
        return j;
    }

    public final long zzgx() {
        AppMethodBeat.i(68565);
        this.zzacw.zzab();
        long j = this.zzaed;
        AppMethodBeat.o(68565);
        return j;
    }

    public final long zzgy() {
        AppMethodBeat.i(68567);
        this.zzacw.zzab();
        long j = this.zzaef;
        AppMethodBeat.o(68567);
        return j;
    }

    public final long zzgz() {
        AppMethodBeat.i(68569);
        this.zzacw.zzab();
        long j = this.zzaee;
        AppMethodBeat.o(68569);
        return j;
    }

    public final String zzha() {
        AppMethodBeat.i(68571);
        this.zzacw.zzab();
        String str = this.zzaeg;
        AppMethodBeat.o(68571);
        return str;
    }

    public final String zzhb() {
        AppMethodBeat.i(68572);
        this.zzacw.zzab();
        String str = this.zzaeg;
        zzaq(null);
        AppMethodBeat.o(68572);
        return str;
    }

    public final long zzhc() {
        AppMethodBeat.i(68574);
        this.zzacw.zzab();
        long j = this.zzadx;
        AppMethodBeat.o(68574);
        return j;
    }

    public final boolean zzhd() {
        AppMethodBeat.i(68576);
        this.zzacw.zzab();
        boolean z = this.zzady;
        AppMethodBeat.o(68576);
        return z;
    }

    public final boolean zzhe() {
        AppMethodBeat.i(68578);
        this.zzacw.zzab();
        boolean z = this.zzadz;
        AppMethodBeat.o(68578);
        return z;
    }

    public final void zzm(long j) {
        AppMethodBeat.i(68537);
        this.zzacw.zzab();
        this.zzaeh = (this.zzadq != j ? 1 : 0) | this.zzaeh;
        this.zzadq = j;
        AppMethodBeat.o(68537);
    }

    public final void zzn(long j) {
        AppMethodBeat.i(68539);
        this.zzacw.zzab();
        this.zzaeh = (this.zzadr != j ? 1 : 0) | this.zzaeh;
        this.zzadr = j;
        AppMethodBeat.o(68539);
    }

    public final void zzo(long j) {
        AppMethodBeat.i(68543);
        this.zzacw.zzab();
        this.zzaeh = (this.zzads != j ? 1 : 0) | this.zzaeh;
        this.zzads = j;
        AppMethodBeat.o(68543);
    }

    public final void zzp(long j) {
        AppMethodBeat.i(68547);
        this.zzacw.zzab();
        this.zzaeh = (this.zzadu != j ? 1 : 0) | this.zzaeh;
        this.zzadu = j;
        AppMethodBeat.o(68547);
    }

    public final void zzq(long j) {
        AppMethodBeat.i(68549);
        this.zzacw.zzab();
        this.zzaeh = (this.zzadv != j ? 1 : 0) | this.zzaeh;
        this.zzadv = j;
        AppMethodBeat.o(68549);
    }

    public final void zzr(long j) {
        int i = 1;
        AppMethodBeat.i(68552);
        Preconditions.checkArgument(j >= 0);
        this.zzacw.zzab();
        boolean z = this.zzaeh;
        if (this.zzadp == j) {
            i = 0;
        }
        this.zzaeh = z | i;
        this.zzadp = j;
        AppMethodBeat.o(68552);
    }

    public final void zzs(long j) {
        AppMethodBeat.i(68555);
        this.zzacw.zzab();
        this.zzaeh = (this.zzaei != j ? 1 : 0) | this.zzaeh;
        this.zzaei = j;
        AppMethodBeat.o(68555);
    }

    public final void zzt(long j) {
        AppMethodBeat.i(68557);
        this.zzacw.zzab();
        this.zzaeh = (this.zzaej != j ? 1 : 0) | this.zzaeh;
        this.zzaej = j;
        AppMethodBeat.o(68557);
    }

    public final void zzu(long j) {
        AppMethodBeat.i(68560);
        this.zzacw.zzab();
        this.zzaeh = (this.zzaea != j ? 1 : 0) | this.zzaeh;
        this.zzaea = j;
        AppMethodBeat.o(68560);
    }

    public final void zzv(long j) {
        AppMethodBeat.i(68562);
        this.zzacw.zzab();
        this.zzaeh = (this.zzaeb != j ? 1 : 0) | this.zzaeh;
        this.zzaeb = j;
        AppMethodBeat.o(68562);
    }

    public final void zzw(long j) {
        AppMethodBeat.i(68564);
        this.zzacw.zzab();
        this.zzaeh = (this.zzaec != j ? 1 : 0) | this.zzaeh;
        this.zzaec = j;
        AppMethodBeat.o(68564);
    }

    public final void zzx(long j) {
        AppMethodBeat.i(68566);
        this.zzacw.zzab();
        this.zzaeh = (this.zzaed != j ? 1 : 0) | this.zzaeh;
        this.zzaed = j;
        AppMethodBeat.o(68566);
    }

    public final void zzy(long j) {
        AppMethodBeat.i(68568);
        this.zzacw.zzab();
        this.zzaeh = (this.zzaef != j ? 1 : 0) | this.zzaeh;
        this.zzaef = j;
        AppMethodBeat.o(68568);
    }

    public final void zzz(long j) {
        AppMethodBeat.i(68570);
        this.zzacw.zzab();
        this.zzaeh = (this.zzaee != j ? 1 : 0) | this.zzaeh;
        this.zzaee = j;
        AppMethodBeat.o(68570);
    }
}
