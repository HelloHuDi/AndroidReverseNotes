package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19395n;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.view.C31128d;
import com.tencent.wcdb.FileUtils;

public final class zzkq extends zzaby<zzkq> {
    private static volatile zzkq[] zzatg;
    public String zzadl;
    public String zzadm;
    public String zzado;
    public String zzadt;
    public String zzaek;
    public String zzafn;
    public Integer zzath;
    public zzkn[] zzati;
    public zzks[] zzatj;
    public Long zzatk;
    public Long zzatl;
    public Long zzatm;
    public Long zzatn;
    public Long zzato;
    public String zzatp;
    public String zzatq;
    public String zzatr;
    public Integer zzats;
    public Long zzatt;
    public Long zzatu;
    public String zzatv;
    public Boolean zzatw;
    public Long zzatx;
    public Integer zzaty;
    public Boolean zzatz;
    public zzkm[] zzaua;
    public Integer zzaub;
    private Integer zzauc;
    private Integer zzaud;
    public String zzaue;
    public Long zzauf;
    public Long zzaug;
    public String zzauh;
    private String zzaui;
    public Integer zzauj;
    public String zzth;
    public String zzti;

    public zzkq() {
        AppMethodBeat.m2504i(69725);
        this.zzath = null;
        this.zzati = zzkn.zzll();
        this.zzatj = zzks.zzlo();
        this.zzatk = null;
        this.zzatl = null;
        this.zzatm = null;
        this.zzatn = null;
        this.zzato = null;
        this.zzatp = null;
        this.zzatq = null;
        this.zzatr = null;
        this.zzafn = null;
        this.zzats = null;
        this.zzadt = null;
        this.zzti = null;
        this.zzth = null;
        this.zzatt = null;
        this.zzatu = null;
        this.zzatv = null;
        this.zzatw = null;
        this.zzadl = null;
        this.zzatx = null;
        this.zzaty = null;
        this.zzaek = null;
        this.zzadm = null;
        this.zzatz = null;
        this.zzaua = zzkm.zzlk();
        this.zzado = null;
        this.zzaub = null;
        this.zzauc = null;
        this.zzaud = null;
        this.zzaue = null;
        this.zzauf = null;
        this.zzaug = null;
        this.zzauh = null;
        this.zzaui = null;
        this.zzauj = null;
        this.zzbww = null;
        this.zzbxh = -1;
        AppMethodBeat.m2505o(69725);
    }

    public static zzkq[] zzln() {
        if (zzatg == null) {
            synchronized (zzacc.zzbxg) {
                if (zzatg == null) {
                    zzatg = new zzkq[0];
                }
            }
        }
        return zzatg;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(69726);
        if (obj == this) {
            AppMethodBeat.m2505o(69726);
            return true;
        } else if (obj instanceof zzkq) {
            zzkq zzkq = (zzkq) obj;
            if (this.zzath == null) {
                if (zzkq.zzath != null) {
                    AppMethodBeat.m2505o(69726);
                    return false;
                }
            } else if (!this.zzath.equals(zzkq.zzath)) {
                AppMethodBeat.m2505o(69726);
                return false;
            }
            if (!zzacc.equals(this.zzati, zzkq.zzati)) {
                AppMethodBeat.m2505o(69726);
                return false;
            } else if (zzacc.equals(this.zzatj, zzkq.zzatj)) {
                if (this.zzatk == null) {
                    if (zzkq.zzatk != null) {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                } else if (!this.zzatk.equals(zzkq.zzatk)) {
                    AppMethodBeat.m2505o(69726);
                    return false;
                }
                if (this.zzatl == null) {
                    if (zzkq.zzatl != null) {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                } else if (!this.zzatl.equals(zzkq.zzatl)) {
                    AppMethodBeat.m2505o(69726);
                    return false;
                }
                if (this.zzatm == null) {
                    if (zzkq.zzatm != null) {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                } else if (!this.zzatm.equals(zzkq.zzatm)) {
                    AppMethodBeat.m2505o(69726);
                    return false;
                }
                if (this.zzatn == null) {
                    if (zzkq.zzatn != null) {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                } else if (!this.zzatn.equals(zzkq.zzatn)) {
                    AppMethodBeat.m2505o(69726);
                    return false;
                }
                if (this.zzato == null) {
                    if (zzkq.zzato != null) {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                } else if (!this.zzato.equals(zzkq.zzato)) {
                    AppMethodBeat.m2505o(69726);
                    return false;
                }
                if (this.zzatp == null) {
                    if (zzkq.zzatp != null) {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                } else if (!this.zzatp.equals(zzkq.zzatp)) {
                    AppMethodBeat.m2505o(69726);
                    return false;
                }
                if (this.zzatq == null) {
                    if (zzkq.zzatq != null) {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                } else if (!this.zzatq.equals(zzkq.zzatq)) {
                    AppMethodBeat.m2505o(69726);
                    return false;
                }
                if (this.zzatr == null) {
                    if (zzkq.zzatr != null) {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                } else if (!this.zzatr.equals(zzkq.zzatr)) {
                    AppMethodBeat.m2505o(69726);
                    return false;
                }
                if (this.zzafn == null) {
                    if (zzkq.zzafn != null) {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                } else if (!this.zzafn.equals(zzkq.zzafn)) {
                    AppMethodBeat.m2505o(69726);
                    return false;
                }
                if (this.zzats == null) {
                    if (zzkq.zzats != null) {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                } else if (!this.zzats.equals(zzkq.zzats)) {
                    AppMethodBeat.m2505o(69726);
                    return false;
                }
                if (this.zzadt == null) {
                    if (zzkq.zzadt != null) {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                } else if (!this.zzadt.equals(zzkq.zzadt)) {
                    AppMethodBeat.m2505o(69726);
                    return false;
                }
                if (this.zzti == null) {
                    if (zzkq.zzti != null) {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                } else if (!this.zzti.equals(zzkq.zzti)) {
                    AppMethodBeat.m2505o(69726);
                    return false;
                }
                if (this.zzth == null) {
                    if (zzkq.zzth != null) {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                } else if (!this.zzth.equals(zzkq.zzth)) {
                    AppMethodBeat.m2505o(69726);
                    return false;
                }
                if (this.zzatt == null) {
                    if (zzkq.zzatt != null) {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                } else if (!this.zzatt.equals(zzkq.zzatt)) {
                    AppMethodBeat.m2505o(69726);
                    return false;
                }
                if (this.zzatu == null) {
                    if (zzkq.zzatu != null) {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                } else if (!this.zzatu.equals(zzkq.zzatu)) {
                    AppMethodBeat.m2505o(69726);
                    return false;
                }
                if (this.zzatv == null) {
                    if (zzkq.zzatv != null) {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                } else if (!this.zzatv.equals(zzkq.zzatv)) {
                    AppMethodBeat.m2505o(69726);
                    return false;
                }
                if (this.zzatw == null) {
                    if (zzkq.zzatw != null) {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                } else if (!this.zzatw.equals(zzkq.zzatw)) {
                    AppMethodBeat.m2505o(69726);
                    return false;
                }
                if (this.zzadl == null) {
                    if (zzkq.zzadl != null) {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                } else if (!this.zzadl.equals(zzkq.zzadl)) {
                    AppMethodBeat.m2505o(69726);
                    return false;
                }
                if (this.zzatx == null) {
                    if (zzkq.zzatx != null) {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                } else if (!this.zzatx.equals(zzkq.zzatx)) {
                    AppMethodBeat.m2505o(69726);
                    return false;
                }
                if (this.zzaty == null) {
                    if (zzkq.zzaty != null) {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                } else if (!this.zzaty.equals(zzkq.zzaty)) {
                    AppMethodBeat.m2505o(69726);
                    return false;
                }
                if (this.zzaek == null) {
                    if (zzkq.zzaek != null) {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                } else if (!this.zzaek.equals(zzkq.zzaek)) {
                    AppMethodBeat.m2505o(69726);
                    return false;
                }
                if (this.zzadm == null) {
                    if (zzkq.zzadm != null) {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                } else if (!this.zzadm.equals(zzkq.zzadm)) {
                    AppMethodBeat.m2505o(69726);
                    return false;
                }
                if (this.zzatz == null) {
                    if (zzkq.zzatz != null) {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                } else if (!this.zzatz.equals(zzkq.zzatz)) {
                    AppMethodBeat.m2505o(69726);
                    return false;
                }
                if (zzacc.equals(this.zzaua, zzkq.zzaua)) {
                    if (this.zzado == null) {
                        if (zzkq.zzado != null) {
                            AppMethodBeat.m2505o(69726);
                            return false;
                        }
                    } else if (!this.zzado.equals(zzkq.zzado)) {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                    if (this.zzaub == null) {
                        if (zzkq.zzaub != null) {
                            AppMethodBeat.m2505o(69726);
                            return false;
                        }
                    } else if (!this.zzaub.equals(zzkq.zzaub)) {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                    if (this.zzauc == null) {
                        if (zzkq.zzauc != null) {
                            AppMethodBeat.m2505o(69726);
                            return false;
                        }
                    } else if (!this.zzauc.equals(zzkq.zzauc)) {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                    if (this.zzaud == null) {
                        if (zzkq.zzaud != null) {
                            AppMethodBeat.m2505o(69726);
                            return false;
                        }
                    } else if (!this.zzaud.equals(zzkq.zzaud)) {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                    if (this.zzaue == null) {
                        if (zzkq.zzaue != null) {
                            AppMethodBeat.m2505o(69726);
                            return false;
                        }
                    } else if (!this.zzaue.equals(zzkq.zzaue)) {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                    if (this.zzauf == null) {
                        if (zzkq.zzauf != null) {
                            AppMethodBeat.m2505o(69726);
                            return false;
                        }
                    } else if (!this.zzauf.equals(zzkq.zzauf)) {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                    if (this.zzaug == null) {
                        if (zzkq.zzaug != null) {
                            AppMethodBeat.m2505o(69726);
                            return false;
                        }
                    } else if (!this.zzaug.equals(zzkq.zzaug)) {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                    if (this.zzauh == null) {
                        if (zzkq.zzauh != null) {
                            AppMethodBeat.m2505o(69726);
                            return false;
                        }
                    } else if (!this.zzauh.equals(zzkq.zzauh)) {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                    if (this.zzaui == null) {
                        if (zzkq.zzaui != null) {
                            AppMethodBeat.m2505o(69726);
                            return false;
                        }
                    } else if (!this.zzaui.equals(zzkq.zzaui)) {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                    if (this.zzauj == null) {
                        if (zzkq.zzauj != null) {
                            AppMethodBeat.m2505o(69726);
                            return false;
                        }
                    } else if (!this.zzauj.equals(zzkq.zzauj)) {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                    if (this.zzbww != null && !this.zzbww.isEmpty()) {
                        boolean equals = this.zzbww.equals(zzkq.zzbww);
                        AppMethodBeat.m2505o(69726);
                        return equals;
                    } else if (zzkq.zzbww == null || zzkq.zzbww.isEmpty()) {
                        AppMethodBeat.m2505o(69726);
                        return true;
                    } else {
                        AppMethodBeat.m2505o(69726);
                        return false;
                    }
                }
                AppMethodBeat.m2505o(69726);
                return false;
            } else {
                AppMethodBeat.m2505o(69726);
                return false;
            }
        } else {
            AppMethodBeat.m2505o(69726);
            return false;
        }
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.m2504i(69727);
        int hashCode = ((this.zzauj == null ? 0 : this.zzauj.hashCode()) + (((this.zzaui == null ? 0 : this.zzaui.hashCode()) + (((this.zzauh == null ? 0 : this.zzauh.hashCode()) + (((this.zzaug == null ? 0 : this.zzaug.hashCode()) + (((this.zzauf == null ? 0 : this.zzauf.hashCode()) + (((this.zzaue == null ? 0 : this.zzaue.hashCode()) + (((this.zzaud == null ? 0 : this.zzaud.hashCode()) + (((this.zzauc == null ? 0 : this.zzauc.hashCode()) + (((this.zzaub == null ? 0 : this.zzaub.hashCode()) + (((this.zzado == null ? 0 : this.zzado.hashCode()) + (((((this.zzatz == null ? 0 : this.zzatz.hashCode()) + (((this.zzadm == null ? 0 : this.zzadm.hashCode()) + (((this.zzaek == null ? 0 : this.zzaek.hashCode()) + (((this.zzaty == null ? 0 : this.zzaty.hashCode()) + (((this.zzatx == null ? 0 : this.zzatx.hashCode()) + (((this.zzadl == null ? 0 : this.zzadl.hashCode()) + (((this.zzatw == null ? 0 : this.zzatw.hashCode()) + (((this.zzatv == null ? 0 : this.zzatv.hashCode()) + (((this.zzatu == null ? 0 : this.zzatu.hashCode()) + (((this.zzatt == null ? 0 : this.zzatt.hashCode()) + (((this.zzth == null ? 0 : this.zzth.hashCode()) + (((this.zzti == null ? 0 : this.zzti.hashCode()) + (((this.zzadt == null ? 0 : this.zzadt.hashCode()) + (((this.zzats == null ? 0 : this.zzats.hashCode()) + (((this.zzafn == null ? 0 : this.zzafn.hashCode()) + (((this.zzatr == null ? 0 : this.zzatr.hashCode()) + (((this.zzatq == null ? 0 : this.zzatq.hashCode()) + (((this.zzatp == null ? 0 : this.zzatp.hashCode()) + (((this.zzato == null ? 0 : this.zzato.hashCode()) + (((this.zzatn == null ? 0 : this.zzatn.hashCode()) + (((this.zzatm == null ? 0 : this.zzatm.hashCode()) + (((this.zzatl == null ? 0 : this.zzatl.hashCode()) + (((this.zzatk == null ? 0 : this.zzatk.hashCode()) + (((((((this.zzath == null ? 0 : this.zzath.hashCode()) + ((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31)) * 31) + zzacc.hashCode(this.zzati)) * 31) + zzacc.hashCode(this.zzatj)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + zzacc.hashCode(this.zzaua)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (!(this.zzbww == null || this.zzbww.isEmpty())) {
            i = this.zzbww.hashCode();
        }
        hashCode += i;
        AppMethodBeat.m2505o(69727);
        return hashCode;
    }

    /* Access modifiers changed, original: protected|final */
    public final int zza() {
        int i;
        int i2 = 0;
        AppMethodBeat.m2504i(69729);
        int zza = super.zza();
        if (this.zzath != null) {
            zza += zzabw.zzf(1, this.zzath.intValue());
        }
        if (this.zzati != null && this.zzati.length > 0) {
            i = zza;
            for (zzace zzace : this.zzati) {
                if (zzace != null) {
                    i += zzabw.zzb(2, zzace);
                }
            }
            zza = i;
        }
        if (this.zzatj != null && this.zzatj.length > 0) {
            i = zza;
            for (zzace zzace2 : this.zzatj) {
                if (zzace2 != null) {
                    i += zzabw.zzb(3, zzace2);
                }
            }
            zza = i;
        }
        if (this.zzatk != null) {
            zza += zzabw.zzc(4, this.zzatk.longValue());
        }
        if (this.zzatl != null) {
            zza += zzabw.zzc(5, this.zzatl.longValue());
        }
        if (this.zzatm != null) {
            zza += zzabw.zzc(6, this.zzatm.longValue());
        }
        if (this.zzato != null) {
            zza += zzabw.zzc(7, this.zzato.longValue());
        }
        if (this.zzatp != null) {
            zza += zzabw.zzc(8, this.zzatp);
        }
        if (this.zzatq != null) {
            zza += zzabw.zzc(9, this.zzatq);
        }
        if (this.zzatr != null) {
            zza += zzabw.zzc(10, this.zzatr);
        }
        if (this.zzafn != null) {
            zza += zzabw.zzc(11, this.zzafn);
        }
        if (this.zzats != null) {
            zza += zzabw.zzf(12, this.zzats.intValue());
        }
        if (this.zzadt != null) {
            zza += zzabw.zzc(13, this.zzadt);
        }
        if (this.zzti != null) {
            zza += zzabw.zzc(14, this.zzti);
        }
        if (this.zzth != null) {
            zza += zzabw.zzc(16, this.zzth);
        }
        if (this.zzatt != null) {
            zza += zzabw.zzc(17, this.zzatt.longValue());
        }
        if (this.zzatu != null) {
            zza += zzabw.zzc(18, this.zzatu.longValue());
        }
        if (this.zzatv != null) {
            zza += zzabw.zzc(19, this.zzatv);
        }
        if (this.zzatw != null) {
            this.zzatw.booleanValue();
            zza += zzabw.zzaq(20) + 1;
        }
        if (this.zzadl != null) {
            zza += zzabw.zzc(21, this.zzadl);
        }
        if (this.zzatx != null) {
            zza += zzabw.zzc(22, this.zzatx.longValue());
        }
        if (this.zzaty != null) {
            zza += zzabw.zzf(23, this.zzaty.intValue());
        }
        if (this.zzaek != null) {
            zza += zzabw.zzc(24, this.zzaek);
        }
        if (this.zzadm != null) {
            zza += zzabw.zzc(25, this.zzadm);
        }
        if (this.zzatn != null) {
            zza += zzabw.zzc(26, this.zzatn.longValue());
        }
        if (this.zzatz != null) {
            this.zzatz.booleanValue();
            zza += zzabw.zzaq(28) + 1;
        }
        if (this.zzaua != null && this.zzaua.length > 0) {
            while (i2 < this.zzaua.length) {
                zzace zzace3 = this.zzaua[i2];
                if (zzace3 != null) {
                    zza += zzabw.zzb(29, zzace3);
                }
                i2++;
            }
        }
        if (this.zzado != null) {
            zza += zzabw.zzc(30, this.zzado);
        }
        if (this.zzaub != null) {
            zza += zzabw.zzf(31, this.zzaub.intValue());
        }
        if (this.zzauc != null) {
            zza += zzabw.zzf(32, this.zzauc.intValue());
        }
        if (this.zzaud != null) {
            zza += zzabw.zzf(33, this.zzaud.intValue());
        }
        if (this.zzaue != null) {
            zza += zzabw.zzc(34, this.zzaue);
        }
        if (this.zzauf != null) {
            zza += zzabw.zzc(35, this.zzauf.longValue());
        }
        if (this.zzaug != null) {
            zza += zzabw.zzc(36, this.zzaug.longValue());
        }
        if (this.zzauh != null) {
            zza += zzabw.zzc(37, this.zzauh);
        }
        if (this.zzaui != null) {
            zza += zzabw.zzc(38, this.zzaui);
        }
        if (this.zzauj != null) {
            zza += zzabw.zzf(39, this.zzauj.intValue());
        }
        AppMethodBeat.m2505o(69729);
        return zza;
    }

    public final void zza(zzabw zzabw) {
        int i = 0;
        AppMethodBeat.m2504i(69728);
        if (this.zzath != null) {
            zzabw.zze(1, this.zzath.intValue());
        }
        if (this.zzati != null && this.zzati.length > 0) {
            for (zzace zzace : this.zzati) {
                if (zzace != null) {
                    zzabw.zza(2, zzace);
                }
            }
        }
        if (this.zzatj != null && this.zzatj.length > 0) {
            for (zzace zzace2 : this.zzatj) {
                if (zzace2 != null) {
                    zzabw.zza(3, zzace2);
                }
            }
        }
        if (this.zzatk != null) {
            zzabw.zzb(4, this.zzatk.longValue());
        }
        if (this.zzatl != null) {
            zzabw.zzb(5, this.zzatl.longValue());
        }
        if (this.zzatm != null) {
            zzabw.zzb(6, this.zzatm.longValue());
        }
        if (this.zzato != null) {
            zzabw.zzb(7, this.zzato.longValue());
        }
        if (this.zzatp != null) {
            zzabw.zzb(8, this.zzatp);
        }
        if (this.zzatq != null) {
            zzabw.zzb(9, this.zzatq);
        }
        if (this.zzatr != null) {
            zzabw.zzb(10, this.zzatr);
        }
        if (this.zzafn != null) {
            zzabw.zzb(11, this.zzafn);
        }
        if (this.zzats != null) {
            zzabw.zze(12, this.zzats.intValue());
        }
        if (this.zzadt != null) {
            zzabw.zzb(13, this.zzadt);
        }
        if (this.zzti != null) {
            zzabw.zzb(14, this.zzti);
        }
        if (this.zzth != null) {
            zzabw.zzb(16, this.zzth);
        }
        if (this.zzatt != null) {
            zzabw.zzb(17, this.zzatt.longValue());
        }
        if (this.zzatu != null) {
            zzabw.zzb(18, this.zzatu.longValue());
        }
        if (this.zzatv != null) {
            zzabw.zzb(19, this.zzatv);
        }
        if (this.zzatw != null) {
            zzabw.zza(20, this.zzatw.booleanValue());
        }
        if (this.zzadl != null) {
            zzabw.zzb(21, this.zzadl);
        }
        if (this.zzatx != null) {
            zzabw.zzb(22, this.zzatx.longValue());
        }
        if (this.zzaty != null) {
            zzabw.zze(23, this.zzaty.intValue());
        }
        if (this.zzaek != null) {
            zzabw.zzb(24, this.zzaek);
        }
        if (this.zzadm != null) {
            zzabw.zzb(25, this.zzadm);
        }
        if (this.zzatn != null) {
            zzabw.zzb(26, this.zzatn.longValue());
        }
        if (this.zzatz != null) {
            zzabw.zza(28, this.zzatz.booleanValue());
        }
        if (this.zzaua != null && this.zzaua.length > 0) {
            while (i < this.zzaua.length) {
                zzace zzace3 = this.zzaua[i];
                if (zzace3 != null) {
                    zzabw.zza(29, zzace3);
                }
                i++;
            }
        }
        if (this.zzado != null) {
            zzabw.zzb(30, this.zzado);
        }
        if (this.zzaub != null) {
            zzabw.zze(31, this.zzaub.intValue());
        }
        if (this.zzauc != null) {
            zzabw.zze(32, this.zzauc.intValue());
        }
        if (this.zzaud != null) {
            zzabw.zze(33, this.zzaud.intValue());
        }
        if (this.zzaue != null) {
            zzabw.zzb(34, this.zzaue);
        }
        if (this.zzauf != null) {
            zzabw.zzb(35, this.zzauf.longValue());
        }
        if (this.zzaug != null) {
            zzabw.zzb(36, this.zzaug.longValue());
        }
        if (this.zzauh != null) {
            zzabw.zzb(37, this.zzauh);
        }
        if (this.zzaui != null) {
            zzabw.zzb(38, this.zzaui);
        }
        if (this.zzauj != null) {
            zzabw.zze(39, this.zzauj.intValue());
        }
        super.zza(zzabw);
        AppMethodBeat.m2505o(69728);
    }

    public final /* synthetic */ zzace zzb(zzabv zzabv) {
        AppMethodBeat.m2504i(69730);
        while (true) {
            int zzuw = zzabv.zzuw();
            int zzb;
            switch (zzuw) {
                case 0:
                    AppMethodBeat.m2505o(69730);
                    break;
                case 8:
                    this.zzath = Integer.valueOf(zzabv.zzuy());
                    continue;
                case 18:
                    zzb = zzach.zzb(zzabv, 18);
                    zzuw = this.zzati == null ? 0 : this.zzati.length;
                    zzkn[] zzknArr = new zzkn[(zzb + zzuw)];
                    if (zzuw != 0) {
                        System.arraycopy(this.zzati, 0, zzknArr, 0, zzuw);
                    }
                    while (zzuw < zzknArr.length - 1) {
                        zzknArr[zzuw] = new zzkn();
                        zzabv.zza(zzknArr[zzuw]);
                        zzabv.zzuw();
                        zzuw++;
                    }
                    zzknArr[zzuw] = new zzkn();
                    zzabv.zza(zzknArr[zzuw]);
                    this.zzati = zzknArr;
                    continue;
                case 26:
                    zzb = zzach.zzb(zzabv, 26);
                    zzuw = this.zzatj == null ? 0 : this.zzatj.length;
                    zzks[] zzksArr = new zzks[(zzb + zzuw)];
                    if (zzuw != 0) {
                        System.arraycopy(this.zzatj, 0, zzksArr, 0, zzuw);
                    }
                    while (zzuw < zzksArr.length - 1) {
                        zzksArr[zzuw] = new zzks();
                        zzabv.zza(zzksArr[zzuw]);
                        zzabv.zzuw();
                        zzuw++;
                    }
                    zzksArr[zzuw] = new zzks();
                    zzabv.zza(zzksArr[zzuw]);
                    this.zzatj = zzksArr;
                    continue;
                case 32:
                    this.zzatk = Long.valueOf(zzabv.zzuz());
                    continue;
                case 40:
                    this.zzatl = Long.valueOf(zzabv.zzuz());
                    continue;
                case 48:
                    this.zzatm = Long.valueOf(zzabv.zzuz());
                    continue;
                case FileUtils.S_IRWXG /*56*/:
                    this.zzato = Long.valueOf(zzabv.zzuz());
                    continue;
                case 66:
                    this.zzatp = zzabv.readString();
                    continue;
                case 74:
                    this.zzatq = zzabv.readString();
                    continue;
                case 82:
                    this.zzatr = zzabv.readString();
                    continue;
                case 90:
                    this.zzafn = zzabv.readString();
                    continue;
                case 96:
                    this.zzats = Integer.valueOf(zzabv.zzuy());
                    continue;
                case 106:
                    this.zzadt = zzabv.readString();
                    continue;
                case 114:
                    this.zzti = zzabv.readString();
                    continue;
                case 130:
                    this.zzth = zzabv.readString();
                    continue;
                case C19395n.CTRL_INDEX /*136*/:
                    this.zzatt = Long.valueOf(zzabv.zzuz());
                    continue;
                case 144:
                    this.zzatu = Long.valueOf(zzabv.zzuz());
                    continue;
                case JsApiMakeVoIPCall.CTRL_INDEX /*154*/:
                    this.zzatv = zzabv.readString();
                    continue;
                case 160:
                    this.zzatw = Boolean.valueOf(zzabv.zzux());
                    continue;
                case ErrorCode.NEEDDOWNLOAD_TRUE /*170*/:
                    this.zzadl = zzabv.readString();
                    continue;
                case ErrorCode.NEEDDOWNLOAD_FALSE_6 /*176*/:
                    this.zzatx = Long.valueOf(zzabv.zzuz());
                    continue;
                case FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE /*184*/:
                    this.zzaty = Integer.valueOf(zzabv.zzuy());
                    continue;
                case JsApiUploadEncryptedFileToCDN.CTRL_INDEX /*194*/:
                    this.zzaek = zzabv.readString();
                    continue;
                case 202:
                    this.zzadm = zzabv.readString();
                    continue;
                case 208:
                    this.zzatn = Long.valueOf(zzabv.zzuz());
                    continue;
                case 224:
                    this.zzatz = Boolean.valueOf(zzabv.zzux());
                    continue;
                case C31128d.MIC_PTU_FENGJING /*234*/:
                    zzb = zzach.zzb(zzabv, C31128d.MIC_PTU_FENGJING);
                    zzuw = this.zzaua == null ? 0 : this.zzaua.length;
                    zzkm[] zzkmArr = new zzkm[(zzb + zzuw)];
                    if (zzuw != 0) {
                        System.arraycopy(this.zzaua, 0, zzkmArr, 0, zzuw);
                    }
                    while (zzuw < zzkmArr.length - 1) {
                        zzkmArr[zzuw] = new zzkm();
                        zzabv.zza(zzkmArr[zzuw]);
                        zzabv.zzuw();
                        zzuw++;
                    }
                    zzkmArr[zzuw] = new zzkm();
                    zzabv.zza(zzkmArr[zzuw]);
                    this.zzaua = zzkmArr;
                    continue;
                case 242:
                    this.zzado = zzabv.readString();
                    continue;
                case C31128d.MIC_PTU_ZIPAI_THURSDAY /*248*/:
                    this.zzaub = Integer.valueOf(zzabv.zzuy());
                    continue;
                case 256:
                    this.zzauc = Integer.valueOf(zzabv.zzuy());
                    continue;
                case C31128d.MIC_PTU_ZIPAI_GRADIENT_MILKCOFFEE /*264*/:
                    this.zzaud = Integer.valueOf(zzabv.zzuy());
                    continue;
                case 274:
                    this.zzaue = zzabv.readString();
                    continue;
                case C31128d.MIC_PTU_TRANS_XINXIAN /*280*/:
                    this.zzauf = Long.valueOf(zzabv.zzuz());
                    continue;
                case C31128d.MIC_PTU_YOUJIALI /*288*/:
                    this.zzaug = Long.valueOf(zzabv.zzuz());
                    continue;
                case 298:
                    this.zzauh = zzabv.readString();
                    continue;
                case 306:
                    this.zzaui = zzabv.readString();
                    continue;
                case 312:
                    this.zzauj = Integer.valueOf(zzabv.zzuy());
                    continue;
                default:
                    if (!super.zza(zzabv, zzuw)) {
                        AppMethodBeat.m2505o(69730);
                        break;
                    }
                    continue;
            }
        }
        return this;
    }
}
