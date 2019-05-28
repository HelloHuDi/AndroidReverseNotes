package android.support.constraint.a.a;

import android.support.constraint.a.a.f.a;
import android.support.constraint.a.b;
import android.support.constraint.a.e;
import android.support.constraint.a.h;
import java.util.ArrayList;

final class c {
    /* JADX WARNING: Removed duplicated region for block: B:237:0x056e  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x04d9  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x04ed  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x04f4  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x050f  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x051f  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x052e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void a(g gVar, e eVar, int i) {
        int i2;
        d[] dVarArr;
        int i3;
        int i4;
        if (i == 0) {
            i2 = gVar.jB;
            dVarArr = gVar.jE;
            i3 = i2;
            i4 = 0;
        } else {
            i2 = gVar.jC;
            dVarArr = gVar.jD;
            i3 = i2;
            i4 = 2;
        }
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < i3) {
                d dVar = dVarArr[i6];
                if (!dVar.hu) {
                    dVar.aF();
                }
                dVar.hu = true;
                if (!gVar.z(4) || !k.a(eVar, i, i4, dVar)) {
                    Object obj;
                    Object obj2;
                    Object obj3;
                    f fVar;
                    e eVar2;
                    e eVar3;
                    f fVar2;
                    e eVar4;
                    h hVar;
                    h hVar2;
                    e eVar5;
                    int aH;
                    e eVar6;
                    f fVar3 = dVar.hf;
                    f fVar4 = dVar.hh;
                    f fVar5 = dVar.hg;
                    f fVar6 = dVar.hi;
                    f fVar7 = dVar.hj;
                    Object obj4 = null;
                    float f = dVar.hp;
                    Object obj5 = gVar.iF[i] == a.WRAP_CONTENT ? 1 : null;
                    if (i == 0) {
                        Object obj6;
                        Object obj7 = fVar7.jg == 0 ? 1 : null;
                        Object obj8 = fVar7.jg == 1 ? 1 : null;
                        if (fVar7.jg == 2) {
                            obj6 = 1;
                        } else {
                            obj6 = null;
                        }
                        obj = obj6;
                        obj2 = obj8;
                        obj3 = obj7;
                        fVar = fVar3;
                    } else {
                        obj = fVar7.jh == 2 ? 1 : null;
                        obj2 = fVar7.jh == 1 ? 1 : null;
                        obj3 = fVar7.jh == 0 ? 1 : null;
                        fVar = fVar3;
                    }
                    while (obj4 == null) {
                        eVar2 = fVar.iD[i4];
                        i5 = 4;
                        if (!(obj5 == null && obj == null)) {
                            i5 = 1;
                        }
                        i2 = eVar2.aH();
                        if (!(eVar2.hy == null || fVar == fVar3)) {
                            i2 += eVar2.hy.aH();
                        }
                        if (obj != null && fVar != fVar3 && fVar != fVar5) {
                            i5 = 6;
                        } else if (!(obj3 == null || obj5 == null)) {
                            i5 = 4;
                        }
                        if (eVar2.hy != null) {
                            if (fVar == fVar5) {
                                eVar.a(eVar2.hE, eVar2.hy.hE, i2, 5);
                            } else {
                                eVar.a(eVar2.hE, eVar2.hy.hE, i2, 6);
                            }
                            eVar.c(eVar2.hE, eVar2.hy.hE, i2, i5);
                        }
                        if (obj5 != null) {
                            if (fVar.iZ != 8 && fVar.iF[i] == a.MATCH_CONSTRAINT) {
                                eVar.a(fVar.iD[i4 + 1].hE, fVar.iD[i4].hE, 0, 5);
                            }
                            eVar.a(fVar.iD[i4].hE, gVar.iD[i4].hE, 0, 6);
                        }
                        eVar3 = fVar.iD[i4 + 1].hy;
                        if (eVar3 != null) {
                            fVar2 = eVar3.hw;
                            if (fVar2.iD[i4].hy == null || fVar2.iD[i4].hy.hw != fVar) {
                                fVar2 = null;
                            }
                        } else {
                            fVar2 = null;
                        }
                        if (fVar2 != null) {
                            fVar = fVar2;
                        } else {
                            obj4 = 1;
                        }
                    }
                    if (!(fVar6 == null || fVar4.iD[i4 + 1].hy == null)) {
                        eVar3 = fVar6.iD[i4 + 1];
                        eVar.b(eVar3.hE, fVar4.iD[i4 + 1].hy.hE, -eVar3.aH(), 5);
                    }
                    if (obj5 != null) {
                        eVar.a(gVar.iD[i4 + 1].hE, fVar4.iD[i4 + 1].hE, fVar4.iD[i4 + 1].aH(), 6);
                    }
                    ArrayList arrayList = dVar.hm;
                    if (arrayList != null) {
                        int size = arrayList.size();
                        if (size > 1) {
                            float f2;
                            f fVar8 = null;
                            float f3 = 0.0f;
                            if (!dVar.hr || dVar.ht) {
                                f2 = f;
                            } else {
                                f2 = (float) dVar.ho;
                            }
                            for (int i7 = 0; i7 < size; i7++) {
                                fVar2 = (f) arrayList.get(i7);
                                f = fVar2.jk[i];
                                if (f < 0.0f) {
                                    if (dVar.ht) {
                                        eVar.c(fVar2.iD[i4 + 1].hE, fVar2.iD[i4].hE, 0, 4);
                                        fVar2 = fVar8;
                                        fVar8 = fVar2;
                                    } else {
                                        f = 1.0f;
                                    }
                                }
                                if (f == 0.0f) {
                                    eVar.c(fVar2.iD[i4 + 1].hE, fVar2.iD[i4].hE, 0, 6);
                                    fVar2 = fVar8;
                                } else {
                                    if (fVar8 != null) {
                                        h hVar3 = fVar8.iD[i4].hE;
                                        h hVar4 = fVar8.iD[i4 + 1].hE;
                                        h hVar5 = fVar2.iD[i4].hE;
                                        h hVar6 = fVar2.iD[i4 + 1].hE;
                                        b ax = eVar.ax();
                                        ax.fG = 0.0f;
                                        if (f2 == 0.0f || f3 == f) {
                                            ax.fI.a(hVar3, 1.0f);
                                            ax.fI.a(hVar4, -1.0f);
                                            ax.fI.a(hVar6, 1.0f);
                                            ax.fI.a(hVar5, -1.0f);
                                        } else if (f3 == 0.0f) {
                                            ax.fI.a(hVar3, 1.0f);
                                            ax.fI.a(hVar4, -1.0f);
                                        } else if (f == 0.0f) {
                                            ax.fI.a(hVar5, 1.0f);
                                            ax.fI.a(hVar6, -1.0f);
                                        } else {
                                            f3 = (f3 / f2) / (f / f2);
                                            ax.fI.a(hVar3, 1.0f);
                                            ax.fI.a(hVar4, -1.0f);
                                            ax.fI.a(hVar6, f3);
                                            ax.fI.a(hVar5, -f3);
                                        }
                                        eVar.b(ax);
                                    }
                                    f3 = f;
                                }
                                fVar8 = fVar2;
                            }
                        }
                    }
                    Object obj9;
                    f fVar9;
                    f fVar10;
                    f fVar11;
                    h hVar7;
                    h hVar8;
                    int aH2;
                    h hVar9;
                    int i8;
                    if (fVar5 != null && (fVar5 == fVar6 || obj != null)) {
                        eVar4 = fVar3.iD[i4];
                        eVar3 = fVar4.iD[i4 + 1];
                        hVar = fVar3.iD[i4].hy != null ? fVar3.iD[i4].hy.hE : null;
                        hVar2 = fVar4.iD[i4 + 1].hy != null ? fVar4.iD[i4 + 1].hy.hE : null;
                        if (fVar5 == fVar6) {
                            eVar4 = fVar5.iD[i4];
                            eVar3 = fVar5.iD[i4 + 1];
                        }
                        if (!(hVar == null || hVar2 == null)) {
                            float f4;
                            if (i == 0) {
                                f4 = fVar7.iV;
                            } else {
                                f4 = fVar7.iW;
                            }
                            eVar.a(eVar4.hE, hVar, eVar4.aH(), f4, hVar2, eVar3.hE, eVar3.aH(), 5);
                        }
                    } else if (obj3 != null && fVar5 != null) {
                        obj9 = (dVar.ho <= 0 || dVar.hn != dVar.ho) ? null : 1;
                        fVar9 = fVar5;
                        fVar10 = fVar5;
                        while (fVar10 != null) {
                            fVar11 = fVar10.jm[i];
                            while (fVar11 != null && fVar11.iZ == 8) {
                                fVar11 = fVar11.jm[i];
                            }
                            if (fVar11 != null || fVar10 == fVar6) {
                                eVar5 = fVar10.iD[i4];
                                hVar7 = eVar5.hE;
                                hVar = eVar5.hy != null ? eVar5.hy.hE : null;
                                if (fVar9 != fVar10) {
                                    hVar8 = fVar9.iD[i4 + 1].hE;
                                } else {
                                    if (fVar10 == fVar5 && fVar9 == fVar10) {
                                        hVar8 = fVar3.iD[i4].hy != null ? fVar3.iD[i4].hy.hE : null;
                                    }
                                    hVar2 = null;
                                    aH = eVar5.aH();
                                    aH2 = fVar10.iD[i4 + 1].aH();
                                    if (fVar11 == null) {
                                        eVar3 = fVar11.iD[i4];
                                        hVar2 = eVar3.hE;
                                    } else {
                                        eVar3 = fVar4.iD[i4 + 1].hy;
                                        if (eVar3 != null) {
                                            hVar2 = eVar3.hE;
                                        }
                                    }
                                    hVar9 = fVar10.iD[i4 + 1].hE;
                                    if (eVar3 != null) {
                                        aH2 += eVar3.aH();
                                    }
                                    if (fVar9 != null) {
                                        aH += fVar9.iD[i4 + 1].aH();
                                    }
                                    if (!(hVar7 == null || hVar == null || hVar2 == null || hVar9 == null)) {
                                        if (fVar10 == fVar5) {
                                            aH = fVar5.iD[i4].aH();
                                        }
                                        if (fVar10 == fVar6) {
                                            aH2 = fVar6.iD[i4 + 1].aH();
                                        }
                                        i8 = 4;
                                        if (obj9 != null) {
                                            i8 = 6;
                                        }
                                        eVar.a(hVar7, hVar, aH, 0.5f, hVar2, hVar9, aH2, i8);
                                    }
                                }
                                hVar = hVar8;
                                hVar2 = null;
                                aH = eVar5.aH();
                                aH2 = fVar10.iD[i4 + 1].aH();
                                if (fVar11 == null) {
                                }
                                hVar9 = fVar10.iD[i4 + 1].hE;
                                if (eVar3 != null) {
                                }
                                if (fVar9 != null) {
                                }
                                if (fVar10 == fVar5) {
                                }
                                if (fVar10 == fVar6) {
                                }
                                i8 = 4;
                                if (obj9 != null) {
                                }
                                eVar.a(hVar7, hVar, aH, 0.5f, hVar2, hVar9, aH2, i8);
                            }
                            if (fVar10.iZ != 8) {
                                fVar2 = fVar10;
                            } else {
                                fVar2 = fVar9;
                            }
                            fVar9 = fVar2;
                            fVar10 = fVar11;
                        }
                    } else if (!(obj2 == null || fVar5 == null)) {
                        obj9 = (dVar.ho <= 0 || dVar.hn != dVar.ho) ? null : 1;
                        fVar11 = fVar5;
                        fVar9 = fVar5;
                        while (fVar9 != null) {
                            fVar2 = fVar9.jm[i];
                            while (fVar2 != null && fVar2.iZ == 8) {
                                fVar2 = fVar2.jm[i];
                            }
                            if (fVar9 == fVar5 || fVar9 == fVar6 || fVar2 == null) {
                                fVar10 = fVar2;
                            } else {
                                if (fVar2 == fVar6) {
                                    fVar10 = null;
                                } else {
                                    fVar10 = fVar2;
                                }
                                eVar5 = fVar9.iD[i4];
                                hVar7 = eVar5.hE;
                                hVar = fVar11.iD[i4 + 1].hE;
                                hVar8 = null;
                                aH = eVar5.aH();
                                aH2 = fVar9.iD[i4 + 1].aH();
                                if (fVar10 != null) {
                                    eVar6 = fVar10.iD[i4];
                                    hVar2 = eVar6.hE;
                                    hVar9 = eVar6.hy != null ? eVar6.hy.hE : null;
                                } else {
                                    eVar6 = fVar9.iD[i4 + 1].hy;
                                    if (eVar6 != null) {
                                        hVar8 = eVar6.hE;
                                    }
                                    hVar9 = fVar9.iD[i4 + 1].hE;
                                    hVar2 = hVar8;
                                }
                                if (eVar6 != null) {
                                    aH2 += eVar6.aH();
                                }
                                if (fVar11 != null) {
                                    aH += fVar11.iD[i4 + 1].aH();
                                }
                                i8 = 4;
                                if (obj9 != null) {
                                    i8 = 6;
                                }
                                if (!(hVar7 == null || hVar == null || hVar2 == null || hVar9 == null)) {
                                    eVar.a(hVar7, hVar, aH, 0.5f, hVar2, hVar9, aH2, i8);
                                }
                            }
                            if (fVar9.iZ != 8) {
                                fVar2 = fVar9;
                            } else {
                                fVar2 = fVar11;
                            }
                            fVar11 = fVar2;
                            fVar9 = fVar10;
                        }
                        eVar3 = fVar5.iD[i4];
                        eVar2 = fVar3.iD[i4].hy;
                        e eVar7 = fVar6.iD[i4 + 1];
                        e eVar8 = fVar4.iD[i4 + 1].hy;
                        if (eVar2 != null) {
                            if (fVar5 != fVar6) {
                                eVar.c(eVar3.hE, eVar2.hE, eVar3.aH(), 5);
                            } else if (eVar8 != null) {
                                eVar.a(eVar3.hE, eVar2.hE, eVar3.aH(), 0.5f, eVar7.hE, eVar8.hE, eVar7.aH(), 5);
                            }
                        }
                        if (!(eVar8 == null || fVar5 == fVar6)) {
                            eVar.c(eVar7.hE, eVar8.hE, -eVar7.aH(), 5);
                        }
                    }
                    if (!((obj3 == null && obj2 == null) || fVar5 == null)) {
                        e eVar9;
                        eVar5 = fVar5.iD[i4];
                        eVar4 = fVar6.iD[i4 + 1];
                        hVar = eVar5.hy != null ? eVar5.hy.hE : null;
                        hVar2 = eVar4.hy != null ? eVar4.hy.hE : null;
                        if (fVar4 != fVar6) {
                            eVar3 = fVar4.iD[i4 + 1];
                            hVar2 = eVar3.hy != null ? eVar3.hy.hE : null;
                        }
                        if (fVar5 == fVar6) {
                            eVar4 = fVar5.iD[i4];
                            eVar9 = fVar5.iD[i4 + 1];
                            eVar6 = eVar4;
                        } else {
                            eVar9 = eVar4;
                            eVar6 = eVar5;
                        }
                        if (!(hVar == null || hVar2 == null)) {
                            aH = eVar6.aH();
                            if (fVar6 == null) {
                                fVar2 = fVar4;
                            } else {
                                fVar2 = fVar6;
                            }
                            eVar.a(eVar6.hE, hVar, aH, 0.5f, hVar2, eVar9.hE, fVar2.iD[i4 + 1].aH(), 5);
                        }
                    }
                }
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }
}
