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
        AppMethodBeat.m2504i(68525);
        Preconditions.checkNotNull(zzgl);
        Preconditions.checkNotEmpty(str);
        this.zzacw = zzgl;
        this.zzti = str;
        this.zzacw.zzab();
        AppMethodBeat.m2505o(68525);
    }

    public final String getAppInstanceId() {
        AppMethodBeat.m2504i(68528);
        this.zzacw.zzab();
        String str = this.zzadl;
        AppMethodBeat.m2505o(68528);
        return str;
    }

    public final String getGmpAppId() {
        AppMethodBeat.m2504i(68530);
        this.zzacw.zzab();
        String str = this.zzadm;
        AppMethodBeat.m2505o(68530);
        return str;
    }

    public final boolean isMeasurementEnabled() {
        AppMethodBeat.m2504i(68550);
        this.zzacw.zzab();
        boolean z = this.zzadw;
        AppMethodBeat.m2505o(68550);
        return z;
    }

    public final void setAppVersion(String str) {
        AppMethodBeat.m2504i(68541);
        this.zzacw.zzab();
        this.zzaeh = (!zzka.zzs(this.zzth, str) ? 1 : 0) | this.zzaeh;
        this.zzth = str;
        AppMethodBeat.m2505o(68541);
    }

    public final void setMeasurementEnabled(boolean z) {
        AppMethodBeat.m2504i(68551);
        this.zzacw.zzab();
        this.zzaeh = (this.zzadw != z ? 1 : 0) | this.zzaeh;
        this.zzadw = z;
        AppMethodBeat.m2505o(68551);
    }

    public final void zzaa(long j) {
        AppMethodBeat.m2504i(68575);
        this.zzacw.zzab();
        this.zzaeh = (this.zzadx != j ? 1 : 0) | this.zzaeh;
        this.zzadx = j;
        AppMethodBeat.m2505o(68575);
    }

    public final String zzag() {
        AppMethodBeat.m2504i(68540);
        this.zzacw.zzab();
        String str = this.zzth;
        AppMethodBeat.m2505o(68540);
        return str;
    }

    public final String zzah() {
        AppMethodBeat.m2504i(68527);
        this.zzacw.zzab();
        String str = this.zzti;
        AppMethodBeat.m2505o(68527);
        return str;
    }

    public final void zzal(String str) {
        AppMethodBeat.m2504i(68529);
        this.zzacw.zzab();
        this.zzaeh = (!zzka.zzs(this.zzadl, str) ? 1 : 0) | this.zzaeh;
        this.zzadl = str;
        AppMethodBeat.m2505o(68529);
    }

    public final void zzam(String str) {
        AppMethodBeat.m2504i(68531);
        this.zzacw.zzab();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzaeh = (!zzka.zzs(this.zzadm, str) ? 1 : 0) | this.zzaeh;
        this.zzadm = str;
        AppMethodBeat.m2505o(68531);
    }

    public final void zzan(String str) {
        AppMethodBeat.m2504i(68533);
        this.zzacw.zzab();
        this.zzaeh = (!zzka.zzs(this.zzadn, str) ? 1 : 0) | this.zzaeh;
        this.zzadn = str;
        AppMethodBeat.m2505o(68533);
    }

    public final void zzao(String str) {
        AppMethodBeat.m2504i(68535);
        this.zzacw.zzab();
        this.zzaeh = (!zzka.zzs(this.zzado, str) ? 1 : 0) | this.zzaeh;
        this.zzado = str;
        AppMethodBeat.m2505o(68535);
    }

    public final void zzap(String str) {
        AppMethodBeat.m2504i(68545);
        this.zzacw.zzab();
        this.zzaeh = (!zzka.zzs(this.zzadt, str) ? 1 : 0) | this.zzaeh;
        this.zzadt = str;
        AppMethodBeat.m2505o(68545);
    }

    public final void zzaq(String str) {
        AppMethodBeat.m2504i(68573);
        this.zzacw.zzab();
        this.zzaeh = (!zzka.zzs(this.zzaeg, str) ? 1 : 0) | this.zzaeh;
        this.zzaeg = str;
        AppMethodBeat.m2505o(68573);
    }

    public final void zzd(boolean z) {
        AppMethodBeat.m2504i(68577);
        this.zzacw.zzab();
        this.zzaeh = this.zzady != z;
        this.zzady = z;
        AppMethodBeat.m2505o(68577);
    }

    public final void zze(boolean z) {
        AppMethodBeat.m2504i(68579);
        this.zzacw.zzab();
        this.zzaeh = this.zzadz != z;
        this.zzadz = z;
        AppMethodBeat.m2505o(68579);
    }

    public final void zzgh() {
        AppMethodBeat.m2504i(68526);
        this.zzacw.zzab();
        this.zzaeh = false;
        AppMethodBeat.m2505o(68526);
    }

    public final String zzgi() {
        AppMethodBeat.m2504i(68532);
        this.zzacw.zzab();
        String str = this.zzadn;
        AppMethodBeat.m2505o(68532);
        return str;
    }

    public final String zzgj() {
        AppMethodBeat.m2504i(68534);
        this.zzacw.zzab();
        String str = this.zzado;
        AppMethodBeat.m2505o(68534);
        return str;
    }

    public final long zzgk() {
        AppMethodBeat.m2504i(68536);
        this.zzacw.zzab();
        long j = this.zzadq;
        AppMethodBeat.m2505o(68536);
        return j;
    }

    public final long zzgl() {
        AppMethodBeat.m2504i(68538);
        this.zzacw.zzab();
        long j = this.zzadr;
        AppMethodBeat.m2505o(68538);
        return j;
    }

    public final long zzgm() {
        AppMethodBeat.m2504i(68542);
        this.zzacw.zzab();
        long j = this.zzads;
        AppMethodBeat.m2505o(68542);
        return j;
    }

    public final String zzgn() {
        AppMethodBeat.m2504i(68544);
        this.zzacw.zzab();
        String str = this.zzadt;
        AppMethodBeat.m2505o(68544);
        return str;
    }

    public final long zzgo() {
        AppMethodBeat.m2504i(68546);
        this.zzacw.zzab();
        long j = this.zzadu;
        AppMethodBeat.m2505o(68546);
        return j;
    }

    public final long zzgp() {
        AppMethodBeat.m2504i(68548);
        this.zzacw.zzab();
        long j = this.zzadv;
        AppMethodBeat.m2505o(68548);
        return j;
    }

    public final long zzgq() {
        AppMethodBeat.m2504i(68553);
        this.zzacw.zzab();
        long j = this.zzadp;
        AppMethodBeat.m2505o(68553);
        return j;
    }

    public final long zzgr() {
        AppMethodBeat.m2504i(68554);
        this.zzacw.zzab();
        long j = this.zzaei;
        AppMethodBeat.m2505o(68554);
        return j;
    }

    public final long zzgs() {
        AppMethodBeat.m2504i(68556);
        this.zzacw.zzab();
        long j = this.zzaej;
        AppMethodBeat.m2505o(68556);
        return j;
    }

    public final void zzgt() {
        AppMethodBeat.m2504i(68558);
        this.zzacw.zzab();
        long j = this.zzadp + 1;
        if (j > 2147483647L) {
            this.zzacw.zzge().zzip().zzg("Bundle index overflow. appId", zzfg.zzbm(this.zzti));
            j = 0;
        }
        this.zzaeh = true;
        this.zzadp = j;
        AppMethodBeat.m2505o(68558);
    }

    public final long zzgu() {
        AppMethodBeat.m2504i(68559);
        this.zzacw.zzab();
        long j = this.zzaea;
        AppMethodBeat.m2505o(68559);
        return j;
    }

    public final long zzgv() {
        AppMethodBeat.m2504i(68561);
        this.zzacw.zzab();
        long j = this.zzaeb;
        AppMethodBeat.m2505o(68561);
        return j;
    }

    public final long zzgw() {
        AppMethodBeat.m2504i(68563);
        this.zzacw.zzab();
        long j = this.zzaec;
        AppMethodBeat.m2505o(68563);
        return j;
    }

    public final long zzgx() {
        AppMethodBeat.m2504i(68565);
        this.zzacw.zzab();
        long j = this.zzaed;
        AppMethodBeat.m2505o(68565);
        return j;
    }

    public final long zzgy() {
        AppMethodBeat.m2504i(68567);
        this.zzacw.zzab();
        long j = this.zzaef;
        AppMethodBeat.m2505o(68567);
        return j;
    }

    public final long zzgz() {
        AppMethodBeat.m2504i(68569);
        this.zzacw.zzab();
        long j = this.zzaee;
        AppMethodBeat.m2505o(68569);
        return j;
    }

    public final String zzha() {
        AppMethodBeat.m2504i(68571);
        this.zzacw.zzab();
        String str = this.zzaeg;
        AppMethodBeat.m2505o(68571);
        return str;
    }

    public final String zzhb() {
        AppMethodBeat.m2504i(68572);
        this.zzacw.zzab();
        String str = this.zzaeg;
        zzaq(null);
        AppMethodBeat.m2505o(68572);
        return str;
    }

    public final long zzhc() {
        AppMethodBeat.m2504i(68574);
        this.zzacw.zzab();
        long j = this.zzadx;
        AppMethodBeat.m2505o(68574);
        return j;
    }

    public final boolean zzhd() {
        AppMethodBeat.m2504i(68576);
        this.zzacw.zzab();
        boolean z = this.zzady;
        AppMethodBeat.m2505o(68576);
        return z;
    }

    public final boolean zzhe() {
        AppMethodBeat.m2504i(68578);
        this.zzacw.zzab();
        boolean z = this.zzadz;
        AppMethodBeat.m2505o(68578);
        return z;
    }

    public final void zzm(long j) {
        AppMethodBeat.m2504i(68537);
        this.zzacw.zzab();
        this.zzaeh = (this.zzadq != j ? 1 : 0) | this.zzaeh;
        this.zzadq = j;
        AppMethodBeat.m2505o(68537);
    }

    public final void zzn(long j) {
        AppMethodBeat.m2504i(68539);
        this.zzacw.zzab();
        this.zzaeh = (this.zzadr != j ? 1 : 0) | this.zzaeh;
        this.zzadr = j;
        AppMethodBeat.m2505o(68539);
    }

    public final void zzo(long j) {
        AppMethodBeat.m2504i(68543);
        this.zzacw.zzab();
        this.zzaeh = (this.zzads != j ? 1 : 0) | this.zzaeh;
        this.zzads = j;
        AppMethodBeat.m2505o(68543);
    }

    public final void zzp(long j) {
        AppMethodBeat.m2504i(68547);
        this.zzacw.zzab();
        this.zzaeh = (this.zzadu != j ? 1 : 0) | this.zzaeh;
        this.zzadu = j;
        AppMethodBeat.m2505o(68547);
    }

    public final void zzq(long j) {
        AppMethodBeat.m2504i(68549);
        this.zzacw.zzab();
        this.zzaeh = (this.zzadv != j ? 1 : 0) | this.zzaeh;
        this.zzadv = j;
        AppMethodBeat.m2505o(68549);
    }

    public final void zzr(long j) {
        int i = 1;
        AppMethodBeat.m2504i(68552);
        Preconditions.checkArgument(j >= 0);
        this.zzacw.zzab();
        boolean z = this.zzaeh;
        if (this.zzadp == j) {
            i = 0;
        }
        this.zzaeh = z | i;
        this.zzadp = j;
        AppMethodBeat.m2505o(68552);
    }

    public final void zzs(long j) {
        AppMethodBeat.m2504i(68555);
        this.zzacw.zzab();
        this.zzaeh = (this.zzaei != j ? 1 : 0) | this.zzaeh;
        this.zzaei = j;
        AppMethodBeat.m2505o(68555);
    }

    public final void zzt(long j) {
        AppMethodBeat.m2504i(68557);
        this.zzacw.zzab();
        this.zzaeh = (this.zzaej != j ? 1 : 0) | this.zzaeh;
        this.zzaej = j;
        AppMethodBeat.m2505o(68557);
    }

    public final void zzu(long j) {
        AppMethodBeat.m2504i(68560);
        this.zzacw.zzab();
        this.zzaeh = (this.zzaea != j ? 1 : 0) | this.zzaeh;
        this.zzaea = j;
        AppMethodBeat.m2505o(68560);
    }

    public final void zzv(long j) {
        AppMethodBeat.m2504i(68562);
        this.zzacw.zzab();
        this.zzaeh = (this.zzaeb != j ? 1 : 0) | this.zzaeh;
        this.zzaeb = j;
        AppMethodBeat.m2505o(68562);
    }

    public final void zzw(long j) {
        AppMethodBeat.m2504i(68564);
        this.zzacw.zzab();
        this.zzaeh = (this.zzaec != j ? 1 : 0) | this.zzaeh;
        this.zzaec = j;
        AppMethodBeat.m2505o(68564);
    }

    public final void zzx(long j) {
        AppMethodBeat.m2504i(68566);
        this.zzacw.zzab();
        this.zzaeh = (this.zzaed != j ? 1 : 0) | this.zzaeh;
        this.zzaed = j;
        AppMethodBeat.m2505o(68566);
    }

    public final void zzy(long j) {
        AppMethodBeat.m2504i(68568);
        this.zzacw.zzab();
        this.zzaeh = (this.zzaef != j ? 1 : 0) | this.zzaeh;
        this.zzaef = j;
        AppMethodBeat.m2505o(68568);
    }

    public final void zzz(long j) {
        AppMethodBeat.m2504i(68570);
        this.zzacw.zzab();
        this.zzaeh = (this.zzaee != j ? 1 : 0) | this.zzaeh;
        this.zzaee = j;
        AppMethodBeat.m2505o(68570);
    }
}
