package android.support.constraint.a.a;

import android.support.constraint.a.a.f.a;
import android.support.constraint.a.e;
import android.support.constraint.a.f;

public final class k {
    static boolean[] ki = new boolean[3];

    static void a(g gVar, e eVar, f fVar) {
        int i;
        int width;
        if (gVar.iF[0] != a.WRAP_CONTENT && fVar.iF[0] == a.MATCH_PARENT) {
            i = fVar.iu.hz;
            width = gVar.getWidth() - fVar.ix.hz;
            fVar.iu.hE = eVar.g(fVar.iu);
            fVar.ix.hE = eVar.g(fVar.ix);
            eVar.a(fVar.iu.hE, i);
            eVar.a(fVar.ix.hE, width);
            fVar.hX = 2;
            fVar.g(i, width);
        }
        if (gVar.iF[1] != a.WRAP_CONTENT && fVar.iF[1] == a.MATCH_PARENT) {
            i = fVar.iw.hz;
            width = gVar.getHeight() - fVar.iy.hz;
            fVar.iw.hE = eVar.g(fVar.iw);
            fVar.iy.hE = eVar.g(fVar.iy);
            eVar.a(fVar.iw.hE, i);
            eVar.a(fVar.iy.hE, width);
            if (fVar.iR > 0 || fVar.iZ == 8) {
                fVar.iz.hE = eVar.g(fVar.iz);
                eVar.a(fVar.iz.hE, fVar.iR + i);
            }
            fVar.hY = 2;
            fVar.h(i, width);
        }
    }

    private static boolean d(f fVar, int i) {
        int i2 = 1;
        if (fVar.iF[i] != a.MATCH_CONSTRAINT) {
            return false;
        }
        if (fVar.iH != 0.0f) {
            a[] aVarArr = fVar.iF;
            if (i != 0) {
                i2 = 0;
            }
            if (aVarArr[i2] == a.MATCH_CONSTRAINT) {
            }
            return false;
        }
        if (i == 0) {
            if (!(fVar.ib == 0 && fVar.f3if == 0 && fVar.ig == 0)) {
                return false;
            }
        } else if (!(fVar.ic == 0 && fVar.ii == 0 && fVar.ij == 0)) {
            return false;
        }
        return true;
    }

    static void a(int i, f fVar) {
        int i2;
        int i3 = 0;
        fVar.aK();
        m mVar = fVar.iu.hv;
        m mVar2 = fVar.iw.hv;
        m mVar3 = fVar.ix.hv;
        m mVar4 = fVar.iy.hv;
        int i4 = (i & 8) == 8 ? 1 : 0;
        if (fVar.iF[0] == a.MATCH_CONSTRAINT && d(fVar, 0)) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (!(mVar.type == 4 || mVar3.type == 4)) {
            if (fVar.iF[0] == a.FIXED || (i2 != 0 && fVar.iZ == 8)) {
                if (fVar.iu.hy == null && fVar.ix.hy == null) {
                    mVar.type = 1;
                    mVar3.type = 1;
                    if (i4 != 0) {
                        mVar3.a(mVar, 1, fVar.aM());
                    } else {
                        mVar3.b(mVar, fVar.getWidth());
                    }
                } else if (fVar.iu.hy != null && fVar.ix.hy == null) {
                    mVar.type = 1;
                    mVar3.type = 1;
                    if (i4 != 0) {
                        mVar3.a(mVar, 1, fVar.aM());
                    } else {
                        mVar3.b(mVar, fVar.getWidth());
                    }
                } else if (fVar.iu.hy == null && fVar.ix.hy != null) {
                    mVar.type = 1;
                    mVar3.type = 1;
                    mVar.b(mVar3, -fVar.getWidth());
                    if (i4 != 0) {
                        mVar.a(mVar3, -1, fVar.aM());
                    } else {
                        mVar.b(mVar3, -fVar.getWidth());
                    }
                } else if (!(fVar.iu.hy == null || fVar.ix.hy == null)) {
                    mVar.type = 2;
                    mVar3.type = 2;
                    if (i4 != 0) {
                        fVar.aM().a(mVar);
                        fVar.aM().a(mVar3);
                        mVar.b(mVar3, -1, fVar.aM());
                        mVar3.b(mVar, 1, fVar.aM());
                    } else {
                        mVar.b(mVar3, (float) (-fVar.getWidth()));
                        mVar3.b(mVar, (float) fVar.getWidth());
                    }
                }
            } else if (i2 != 0) {
                i2 = fVar.getWidth();
                mVar.type = 1;
                mVar3.type = 1;
                if (fVar.iu.hy == null && fVar.ix.hy == null) {
                    if (i4 != 0) {
                        mVar3.a(mVar, 1, fVar.aM());
                    } else {
                        mVar3.b(mVar, i2);
                    }
                } else if (fVar.iu.hy == null || fVar.ix.hy != null) {
                    if (fVar.iu.hy != null || fVar.ix.hy == null) {
                        if (!(fVar.iu.hy == null || fVar.ix.hy == null)) {
                            if (i4 != 0) {
                                fVar.aM().a(mVar);
                                fVar.aM().a(mVar3);
                            }
                            if (fVar.iH == 0.0f) {
                                mVar.type = 3;
                                mVar3.type = 3;
                                mVar.b(mVar3, 0.0f);
                                mVar3.b(mVar, 0.0f);
                            } else {
                                mVar.type = 2;
                                mVar3.type = 2;
                                mVar.b(mVar3, (float) (-i2));
                                mVar3.b(mVar, (float) i2);
                                fVar.setWidth(i2);
                            }
                        }
                    } else if (i4 != 0) {
                        mVar.a(mVar3, -1, fVar.aM());
                    } else {
                        mVar.b(mVar3, -i2);
                    }
                } else if (i4 != 0) {
                    mVar3.a(mVar, 1, fVar.aM());
                } else {
                    mVar3.b(mVar, i2);
                }
            }
        }
        if (fVar.iF[1] == a.MATCH_CONSTRAINT && d(fVar, 1)) {
            i3 = 1;
        }
        if (mVar2.type != 4 && mVar4.type != 4) {
            if (fVar.iF[1] == a.FIXED || (i3 != 0 && fVar.iZ == 8)) {
                if (fVar.iw.hy == null && fVar.iy.hy == null) {
                    mVar2.type = 1;
                    mVar4.type = 1;
                    if (i4 != 0) {
                        mVar4.a(mVar2, 1, fVar.aN());
                    } else {
                        mVar4.b(mVar2, fVar.getHeight());
                    }
                    if (fVar.iz.hy != null) {
                        fVar.iz.hv.type = 1;
                        mVar2.a(fVar.iz.hv, -fVar.iR);
                    }
                } else if (fVar.iw.hy != null && fVar.iy.hy == null) {
                    mVar2.type = 1;
                    mVar4.type = 1;
                    if (i4 != 0) {
                        mVar4.a(mVar2, 1, fVar.aN());
                    } else {
                        mVar4.b(mVar2, fVar.getHeight());
                    }
                    if (fVar.iR > 0) {
                        fVar.iz.hv.a(mVar2, fVar.iR);
                    }
                } else if (fVar.iw.hy == null && fVar.iy.hy != null) {
                    mVar2.type = 1;
                    mVar4.type = 1;
                    if (i4 != 0) {
                        mVar2.a(mVar4, -1, fVar.aN());
                    } else {
                        mVar2.b(mVar4, -fVar.getHeight());
                    }
                    if (fVar.iR > 0) {
                        fVar.iz.hv.a(mVar2, fVar.iR);
                    }
                } else if (fVar.iw.hy != null && fVar.iy.hy != null) {
                    mVar2.type = 2;
                    mVar4.type = 2;
                    if (i4 != 0) {
                        mVar2.b(mVar4, -1, fVar.aN());
                        mVar4.b(mVar2, 1, fVar.aN());
                        fVar.aN().a(mVar2);
                        fVar.aM().a(mVar4);
                    } else {
                        mVar2.b(mVar4, (float) (-fVar.getHeight()));
                        mVar4.b(mVar2, (float) fVar.getHeight());
                    }
                    if (fVar.iR > 0) {
                        fVar.iz.hv.a(mVar2, fVar.iR);
                    }
                }
            } else if (i3 != 0) {
                i3 = fVar.getHeight();
                mVar2.type = 1;
                mVar4.type = 1;
                if (fVar.iw.hy == null && fVar.iy.hy == null) {
                    if (i4 != 0) {
                        mVar4.a(mVar2, 1, fVar.aN());
                    } else {
                        mVar4.b(mVar2, i3);
                    }
                } else if (fVar.iw.hy == null || fVar.iy.hy != null) {
                    if (fVar.iw.hy != null || fVar.iy.hy == null) {
                        if (fVar.iw.hy != null && fVar.iy.hy != null) {
                            if (i4 != 0) {
                                fVar.aN().a(mVar2);
                                fVar.aM().a(mVar4);
                            }
                            if (fVar.iH == 0.0f) {
                                mVar2.type = 3;
                                mVar4.type = 3;
                                mVar2.b(mVar4, 0.0f);
                                mVar4.b(mVar2, 0.0f);
                                return;
                            }
                            mVar2.type = 2;
                            mVar4.type = 2;
                            mVar2.b(mVar4, (float) (-i3));
                            mVar4.b(mVar2, (float) i3);
                            fVar.setHeight(i3);
                            if (fVar.iR > 0) {
                                fVar.iz.hv.a(mVar2, fVar.iR);
                            }
                        }
                    } else if (i4 != 0) {
                        mVar2.a(mVar4, -1, fVar.aN());
                    } else {
                        mVar2.b(mVar4, -i3);
                    }
                } else if (i4 != 0) {
                    mVar4.a(mVar2, 1, fVar.aN());
                } else {
                    mVar4.b(mVar2, i3);
                }
            }
        }
    }

    static boolean a(e eVar, int i, int i2, d dVar) {
        Object obj;
        Object obj2;
        Object obj3;
        float width;
        f fVar = dVar.hf;
        f fVar2 = dVar.hh;
        f fVar3 = dVar.hg;
        f fVar4 = dVar.hi;
        f fVar5 = dVar.hj;
        Object obj4 = null;
        int i3 = 0;
        float f = dVar.hp;
        a aVar = a.WRAP_CONTENT;
        if (i == 0) {
            obj = fVar5.jg == 0 ? 1 : null;
            obj2 = fVar5.jg == 1 ? 1 : null;
            obj3 = fVar5.jg == 2 ? 1 : null;
        } else {
            obj = fVar5.jh == 0 ? 1 : null;
            obj2 = fVar5.jh == 1 ? 1 : null;
            obj3 = fVar5.jh == 2 ? 1 : null;
        }
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i4 = 0;
        f fVar6 = fVar;
        while (obj4 == null) {
            int i5;
            f fVar7;
            if (fVar6.iZ != 8) {
                i5 = i4 + 1;
                if (i == 0) {
                    width = ((float) fVar6.getWidth()) + f2;
                } else {
                    width = ((float) fVar6.getHeight()) + f2;
                }
                if (fVar6 != fVar3) {
                    width += (float) fVar6.iD[i2].aH();
                }
                if (fVar6 != fVar4) {
                    width += (float) fVar6.iD[i2 + 1].aH();
                }
                f3 = (f3 + ((float) fVar6.iD[i2].aH())) + ((float) fVar6.iD[i2 + 1].aH());
                f2 = width;
            } else {
                i5 = i4;
            }
            if (fVar6.iZ != 8 && fVar6.iF[i] == a.MATCH_CONSTRAINT) {
                i4 = i3 + 1;
                if (i == 0) {
                    if (fVar6.ib != 0) {
                        return false;
                    }
                    if (!(fVar6.f3if == 0 && fVar6.ig == 0)) {
                        return false;
                    }
                } else if (fVar6.ic != 0) {
                    return false;
                } else {
                    if (!(fVar6.ii == 0 && fVar6.ij == 0)) {
                        return false;
                    }
                }
                if (fVar6.iH != 0.0f) {
                    return false;
                }
                i3 = i4;
            }
            e eVar2 = fVar6.iD[i2 + 1].hy;
            if (eVar2 != null) {
                fVar7 = eVar2.hw;
                if (fVar7.iD[i2].hy == null || fVar7.iD[i2].hy.hw != fVar6) {
                    fVar7 = null;
                }
            } else {
                fVar7 = null;
            }
            if (fVar7 != null) {
                i4 = i5;
                fVar6 = fVar7;
            } else {
                obj4 = 1;
                i4 = i5;
            }
        }
        m mVar = fVar.iD[i2].hv;
        m mVar2 = fVar2.iD[i2 + 1].hv;
        if (mVar.kk == null || mVar2.kk == null) {
            return false;
        }
        if (mVar.kk.state != 1 || mVar2.kk.state != 1) {
            return false;
        }
        if (i3 > 0 && i3 != i4) {
            return false;
        }
        float f4 = 0.0f;
        if (!(obj3 == null && obj == null && obj2 == null)) {
            if (fVar3 != null) {
                f4 = (float) fVar3.iD[i2].aH();
            }
            if (fVar4 != null) {
                f4 += (float) fVar4.iD[i2 + 1].aH();
            }
        }
        float f5 = mVar.kk.km;
        float f6 = mVar2.kk.km;
        if (f5 < f6) {
            f6 = (f6 - f5) - f2;
        } else {
            f6 = (f5 - f6) - f2;
        }
        float f7;
        float f8;
        f fVar8;
        if (i3 <= 0 || i3 != i4) {
            Object obj5;
            Object obj6;
            if (f6 < 0.0f) {
                obj3 = 1;
                obj5 = null;
                obj6 = null;
            } else {
                obj5 = obj2;
                obj6 = obj;
            }
            if (obj3 != null) {
                f7 = f6 - f4;
                if (i == 0) {
                    f8 = fVar.iV;
                } else if (i == 1) {
                    f8 = fVar.iW;
                } else {
                    f8 = -1.0f;
                }
                f7 = f5 + (f8 * f7);
                while (fVar != null) {
                    if (e.gb != null) {
                        fVar8 = e.gb;
                        fVar8.gE--;
                        fVar8 = e.gb;
                        fVar8.gv++;
                        fVar8 = e.gb;
                        fVar8.gB++;
                    }
                    fVar5 = fVar.jm[i];
                    if (fVar5 != null || fVar == fVar2) {
                        if (i == 0) {
                            f8 = (float) fVar.getWidth();
                        } else {
                            f8 = (float) fVar.getHeight();
                        }
                        f7 += (float) fVar.iD[i2].aH();
                        fVar.iD[i2].hv.a(mVar.kl, f7);
                        fVar.iD[i2 + 1].hv.a(mVar.kl, f7 + f8);
                        fVar.iD[i2].hv.c(eVar);
                        fVar.iD[i2 + 1].hv.c(eVar);
                        f8 = (f8 + f7) + ((float) fVar.iD[i2 + 1].aH());
                    } else {
                        f8 = f7;
                    }
                    f7 = f8;
                    fVar = fVar5;
                }
            } else if (!(obj6 == null && obj5 == null)) {
                if (obj6 != null) {
                    f7 = f6 - f4;
                } else if (obj5 != null) {
                    f7 = f6 - f4;
                } else {
                    f7 = f6;
                }
                f8 = f7 / ((float) (i4 + 1));
                if (obj5 != null) {
                    if (i4 > 1) {
                        f8 = f7 / ((float) (i4 - 1));
                    } else {
                        f8 = f7 / 2.0f;
                    }
                }
                if (fVar.iZ != 8) {
                    f7 = f5 + f8;
                } else {
                    f7 = f5;
                }
                if (obj5 != null && i4 > 1) {
                    f7 = ((float) fVar3.iD[i2].aH()) + f5;
                }
                if (obj6 == null || fVar3 == null) {
                    fVar5 = fVar;
                } else {
                    f7 += (float) fVar3.iD[i2].aH();
                    fVar5 = fVar;
                }
                while (fVar5 != null) {
                    if (e.gb != null) {
                        f fVar9 = e.gb;
                        fVar9.gE--;
                        fVar9 = e.gb;
                        fVar9.gv++;
                        fVar9 = e.gb;
                        fVar9.gB++;
                    }
                    f fVar10 = fVar5.jm[i];
                    if (fVar10 != null || fVar5 == fVar2) {
                        if (i == 0) {
                            f4 = (float) fVar5.getWidth();
                        } else {
                            f4 = (float) fVar5.getHeight();
                        }
                        if (fVar5 != fVar3) {
                            f7 += (float) fVar5.iD[i2].aH();
                        }
                        fVar5.iD[i2].hv.a(mVar.kl, f7);
                        fVar5.iD[i2 + 1].hv.a(mVar.kl, f7 + f4);
                        fVar5.iD[i2].hv.c(eVar);
                        fVar5.iD[i2 + 1].hv.c(eVar);
                        f7 += ((float) fVar5.iD[i2 + 1].aH()) + f4;
                        if (!(fVar10 == null || fVar10.iZ == 8)) {
                            f7 += f8;
                        }
                    }
                    fVar5 = fVar10;
                }
            }
            return true;
        } else if (fVar6.iG != null && fVar6.iG.iF[i] == a.WRAP_CONTENT) {
            return false;
        } else {
            width = (f6 + f2) - f3;
            f7 = f5;
            while (fVar != null) {
                if (e.gb != null) {
                    fVar8 = e.gb;
                    fVar8.gE--;
                    fVar8 = e.gb;
                    fVar8.gv++;
                    fVar8 = e.gb;
                    fVar8.gB++;
                }
                fVar5 = fVar.jm[i];
                if (fVar5 != null || fVar == fVar2) {
                    f8 = width / ((float) i3);
                    if (f > 0.0f) {
                        if (fVar.jk[i] == -1.0f) {
                            f8 = 0.0f;
                        } else {
                            f8 = (fVar.jk[i] * width) / f;
                        }
                    }
                    if (fVar.iZ == 8) {
                        f8 = 0.0f;
                    }
                    f7 += (float) fVar.iD[i2].aH();
                    fVar.iD[i2].hv.a(mVar.kl, f7);
                    fVar.iD[i2 + 1].hv.a(mVar.kl, f7 + f8);
                    fVar.iD[i2].hv.c(eVar);
                    fVar.iD[i2 + 1].hv.c(eVar);
                    f8 = (f8 + f7) + ((float) fVar.iD[i2 + 1].aH());
                } else {
                    f8 = f7;
                }
                fVar = fVar5;
                f7 = f8;
            }
            return true;
        }
    }

    static void b(f fVar, int i, int i2) {
        int i3 = i * 2;
        int i4 = i3 + 1;
        fVar.iD[i3].hv.kl = fVar.iG.iu.hv;
        fVar.iD[i3].hv.km = (float) i2;
        fVar.iD[i3].hv.state = 1;
        fVar.iD[i4].hv.kl = fVar.iD[i3].hv;
        fVar.iD[i4].hv.km = (float) fVar.v(i);
        fVar.iD[i4].hv.state = 1;
    }
}
