package com.tencent.mm.plugin.collect.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.bx;
import com.tencent.mm.g.b.a.bf;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class g extends c<bx> implements f, com.tencent.mm.plugin.collect.model.voice.a.c {
    private static final String kBK = (e.eSn + "wallet/voice/");
    private static final com.tencent.mm.bt.b kBL = com.tencent.mm.bt.b.akB("元");
    private boolean isPlaying;
    private MediaPlayer kBM;
    private MediaPlayer kBN;
    public ConcurrentLinkedQueue<b> kBO;
    private int kBP;
    private int kBQ;
    private long kBR;
    private WeakReference<ArrayList<String>> kBS;
    private bf kBT;

    static class a {
        /* JADX WARNING: Removed duplicated region for block: B:34:0x011d A:{SYNTHETIC, Splitter:B:34:0x011d} */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x011d A:{SYNTHETIC, Splitter:B:34:0x011d} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static MediaPlayer a(Context context, final OnCompletionListener onCompletionListener, final OnErrorListener onErrorListener) {
            Exception e;
            Throwable th;
            AppMethodBeat.i(40945);
            if (context == null) {
                ab.e("MicroMsg.F2fRcvVoiceListener", "play Err context:%s pathId:%d", context, Integer.valueOf(R.string.asp));
                AppMethodBeat.o(40945);
                return null;
            }
            final String string = context.getString(R.string.asp);
            final MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(3);
            ab.i("MicroMsg.F2fRcvVoiceListener", "play start mp:%d path:%s context:%s pathId:%d", Integer.valueOf(mediaPlayer.hashCode()), string, context, Integer.valueOf(R.string.asp));
            AssetFileDescriptor assetFileDescriptor = null;
            AssetFileDescriptor openFd;
            try {
                openFd = context.getAssets().openFd(string);
                try {
                    boolean z;
                    mediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                    mediaPlayer.setLooping(false);
                    mediaPlayer.setOnErrorListener(new OnErrorListener() {
                        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            AppMethodBeat.i(40941);
                            ab.i("MicroMsg.F2fRcvVoiceListener", "onError, what: %d, extra: %d", Integer.valueOf(i), Integer.valueOf(i2));
                            if (mediaPlayer != null) {
                                try {
                                    mediaPlayer.release();
                                } catch (Exception e) {
                                }
                            }
                            if (mediaPlayer != null) {
                                mediaPlayer.release();
                            }
                            if (onErrorListener != null) {
                                onErrorListener.onError(mediaPlayer, i, i2);
                            }
                            AppMethodBeat.o(40941);
                            return false;
                        }
                    });
                    mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
                        public final void onCompletion(MediaPlayer mediaPlayer) {
                            AppMethodBeat.i(40942);
                            String str = "MicroMsg.F2fRcvVoiceListener";
                            String str2 = "play completion mp:%d  path:%s";
                            Object[] objArr = new Object[2];
                            objArr[0] = Integer.valueOf(mediaPlayer == null ? -1 : mediaPlayer.hashCode());
                            objArr[1] = string;
                            ab.i(str, str2, objArr);
                            if (mediaPlayer != null) {
                                mediaPlayer.release();
                            }
                            if (mediaPlayer != null) {
                                mediaPlayer.release();
                            }
                            if (onCompletionListener != null) {
                                onCompletionListener.onCompletion(mediaPlayer);
                            }
                            AppMethodBeat.o(40942);
                        }
                    });
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                    String str = "MicroMsg.F2fRcvVoiceListener";
                    String str2 = "play start mp finish [%d], myLooper[%b] mainLooper[%b]";
                    Object[] objArr = new Object[3];
                    objArr[0] = Integer.valueOf(mediaPlayer.hashCode());
                    if (Looper.myLooper() != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objArr[1] = Boolean.valueOf(z);
                    if (Looper.getMainLooper() != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objArr[2] = Boolean.valueOf(z);
                    ab.i(str, str2, objArr);
                    if (openFd != null) {
                        try {
                            openFd.close();
                        } catch (IOException e2) {
                            ab.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", e2, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.o(40945);
                    return mediaPlayer;
                } catch (Exception e3) {
                    e = e3;
                    assetFileDescriptor = openFd;
                    try {
                        ab.e("MicroMsg.F2fRcvVoiceListener", "play failed pathId:%d e:%s", Integer.valueOf(R.string.asp), e.getMessage());
                        ab.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", e, "", new Object[0]);
                        mediaPlayer.release();
                        if (assetFileDescriptor != null) {
                            try {
                                assetFileDescriptor.close();
                            } catch (IOException e4) {
                                ab.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", e4, "", new Object[0]);
                            }
                        }
                        AppMethodBeat.o(40945);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        openFd = assetFileDescriptor;
                        if (openFd != null) {
                        }
                        AppMethodBeat.o(40945);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (openFd != null) {
                    }
                    AppMethodBeat.o(40945);
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
            } catch (Throwable th4) {
                th = th4;
                openFd = null;
                if (openFd != null) {
                    try {
                        openFd.close();
                    } catch (IOException e22) {
                        ab.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", e22, "", new Object[0]);
                    }
                }
                AppMethodBeat.o(40945);
                throw th;
            }
        }

        public static MediaPlayer a(final String str, final OnCompletionListener onCompletionListener, final OnErrorListener onErrorListener) {
            AppMethodBeat.i(40946);
            final MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(3);
            ab.i("MicroMsg.F2fRcvVoiceListener", "play start mp:%d path:%s", Integer.valueOf(mediaPlayer.hashCode()), str);
            try {
                mediaPlayer.setDataSource(str);
                mediaPlayer.setLooping(false);
                mediaPlayer.setOnErrorListener(new OnErrorListener() {
                    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        AppMethodBeat.i(40943);
                        ab.i("MicroMsg.F2fRcvVoiceListener", "onError, what: %d, extra: %d", Integer.valueOf(i), Integer.valueOf(i2));
                        if (mediaPlayer != null) {
                            try {
                                mediaPlayer.release();
                            } catch (Exception e) {
                            }
                        }
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                        if (onErrorListener != null) {
                            onErrorListener.onError(mediaPlayer, i, i2);
                        }
                        AppMethodBeat.o(40943);
                        return false;
                    }
                });
                mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
                    public final void onCompletion(MediaPlayer mediaPlayer) {
                        AppMethodBeat.i(40944);
                        String str = "MicroMsg.F2fRcvVoiceListener";
                        String str2 = "play completion mp:%d  path:%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(mediaPlayer == null ? -1 : mediaPlayer.hashCode());
                        objArr[1] = str;
                        ab.i(str, str2, objArr);
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                        if (onCompletionListener != null) {
                            onCompletionListener.onCompletion(mediaPlayer);
                        }
                        AppMethodBeat.o(40944);
                    }
                });
                mediaPlayer.prepare();
                mediaPlayer.start();
                String str2 = "MicroMsg.F2fRcvVoiceListener";
                String str3 = "play start mp finish [%d], myLooper[%b] mainLooper[%b]";
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(mediaPlayer.hashCode());
                objArr[1] = Boolean.valueOf(Looper.myLooper() != null);
                objArr[2] = Boolean.valueOf(Looper.getMainLooper() != null);
                ab.i(str2, str3, objArr);
                AppMethodBeat.o(40946);
                return mediaPlayer;
            } catch (Exception e) {
                ab.e("MicroMsg.F2fRcvVoiceListener", "play failed path:%s e:%s", str, e.getMessage());
                ab.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", e, "", new Object[0]);
                mediaPlayer.release();
                AppMethodBeat.o(40946);
                return null;
            }
        }
    }

    class b {
        int cAO;
        String cva;
        String fileName;
        int kBZ;
        int kCa;
        boolean kCb;

        private b() {
            this.kCa = 0;
            this.kCb = false;
        }

        /* synthetic */ b(g gVar, byte b) {
            this();
        }
    }

    static /* synthetic */ void a(g gVar, b bVar) {
        AppMethodBeat.i(40962);
        gVar.a(bVar);
        AppMethodBeat.o(40962);
    }

    static /* synthetic */ boolean bgE() {
        AppMethodBeat.i(40965);
        boolean bgB = bgB();
        AppMethodBeat.o(40965);
        return bgB;
    }

    static /* synthetic */ void h(g gVar) {
        AppMethodBeat.i(40964);
        gVar.bgC();
        AppMethodBeat.o(40964);
    }

    static {
        AppMethodBeat.i(40966);
        AppMethodBeat.o(40966);
    }

    public g() {
        AppMethodBeat.i(40947);
        this.isPlaying = false;
        this.xxI = bx.class.getName().hashCode();
        AppMethodBeat.o(40947);
    }

    private List<String> bgA() {
        AppMethodBeat.i(40948);
        if (this.kBS == null || this.kBS.get() == null) {
            ab.i("MicroMsg.F2fRcvVoiceListener", "refer is null");
            this.kBS = new WeakReference(new ArrayList(bo.hT((String) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_F2F_RCV_VOICE_PLAYED_LIST_STRING_SYNC, (Object) ""), ",")));
        }
        List list = (List) this.kBS.get();
        AppMethodBeat.o(40948);
        return list;
    }

    private synchronized boolean Ia(String str) {
        boolean z;
        AppMethodBeat.i(40949);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.F2fRcvVoiceListener", "illegal no: %s, not do play", str);
            AppMethodBeat.o(40949);
            z = true;
        } else {
            List subList;
            List bgA = bgA();
            for (String equals : bgA()) {
                if (equals.equals(str)) {
                    ab.i("MicroMsg.F2fRcvVoiceListener", "has played tradeno: %s", str);
                    AppMethodBeat.o(40949);
                    z = true;
                    break;
                }
            }
            bgA.add(str);
            if (bgA.size() > 10) {
                ab.i("MicroMsg.F2fRcvVoiceListener", "over max size, do remove");
                int size = bgA.size();
                subList = bgA.subList(size - 10, size);
            } else {
                subList = bgA;
            }
            com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WALLET_F2F_RCV_VOICE_PLAYED_LIST_STRING_SYNC, bo.c(subList, ","));
            AppMethodBeat.o(40949);
            z = false;
        }
        return z;
    }

    private static boolean t(String str, byte[] bArr) {
        AppMethodBeat.i(40950);
        com.tencent.mm.kernel.g.RQ();
        if (!com.tencent.mm.kernel.g.RP().isSDCardAvailable()) {
            ab.i("MicroMsg.F2fRcvVoiceListener", "sd card not available");
            AppMethodBeat.o(40950);
            return false;
        } else if (com.tencent.mm.vfs.e.b(str, bArr, bArr.length) == 0) {
            AppMethodBeat.o(40950);
            return true;
        } else {
            AppMethodBeat.o(40950);
            return false;
        }
    }

    public static boolean bgB() {
        AppMethodBeat.i(40951);
        ab.i("MicroMsg.F2fRcvVoiceListener", "delete files");
        boolean N = com.tencent.mm.vfs.e.N(kBK, true);
        AppMethodBeat.o(40951);
        return N;
    }

    private synchronized void bgC() {
        AppMethodBeat.i(40952);
        if (System.currentTimeMillis() - this.kBR > 10000) {
            ab.i("MicroMsg.F2fRcvVoiceListener", "last has outdate: %s", Long.valueOf(this.kBR));
            this.isPlaying = false;
        }
        if (this.isPlaying) {
            ab.i("MicroMsg.F2fRcvVoiceListener", "is playing, return");
            AppMethodBeat.o(40952);
        } else {
            this.isPlaying = true;
            this.kBR = System.currentTimeMillis();
            final b bVar = (b) this.kBO.poll();
            com.tencent.mm.compatible.b.g KK = com.tencent.mm.compatible.b.g.KK();
            int streamMaxVolume = KK.getStreamMaxVolume(3);
            this.kBP = KK.getStreamVolume(3);
            this.kBQ = Math.round(((float) streamMaxVolume) * 0.5f);
            ab.i("MicroMsg.F2fRcvVoiceListener", "curVol: %s, maxVol: %s, minVol: %s", Integer.valueOf(this.kBP), Integer.valueOf(streamMaxVolume), Integer.valueOf(this.kBQ));
            boolean z;
            if (VERSION.SDK_INT >= 23) {
                ab.i("MicroMsg.F2fRcvVoiceListener", "isMute: %s", Boolean.valueOf(KK.eoY.isStreamMute(3)));
                z = r2;
            } else {
                z = false;
            }
            if (this.kBP == 0 || z) {
                ab.i("MicroMsg.F2fRcvVoiceListener", "music channel is mute");
                int i = bVar != null ? bVar.kBZ : 1;
                h hVar = h.pYm;
                Object[] objArr = new Object[5];
                objArr[0] = Integer.valueOf(3);
                objArr[1] = bVar != null ? bVar.cva : "";
                objArr[2] = Integer.valueOf(5);
                objArr[3] = "";
                objArr[4] = Integer.valueOf(i);
                hVar.e(14404, objArr);
            }
            if (this.kBP > 0 && this.kBP < this.kBQ && !z) {
                KK.bR(3, this.kBQ);
            }
            if (bVar != null) {
                ab.i("MicroMsg.F2fRcvVoiceListener", "holder.offLine = %s", Boolean.valueOf(bVar.kCb));
                if (!bVar.kCb) {
                    int i2 = bVar.kBZ;
                    if (bo.isNullOrNil(bVar.fileName)) {
                        this.kBM = a.a(ah.getContext(), new OnCompletionListener() {
                            public final void onCompletion(MediaPlayer mediaPlayer) {
                                AppMethodBeat.i(40937);
                                ab.i("MicroMsg.F2fRcvVoiceListener", "no need to play money this time");
                                g.f(g.this);
                                g.this.isPlaying = false;
                                g.this.kBM = null;
                                com.tencent.mm.plugin.collect.a.a.bgv();
                                h.pYm.e(14404, Integer.valueOf(4), bVar.cva, "", "", Integer.valueOf(bVar.kBZ));
                                if (g.this.kBO.isEmpty()) {
                                    g.bgE();
                                    AppMethodBeat.o(40937);
                                    return;
                                }
                                g.h(g.this);
                                AppMethodBeat.o(40937);
                            }
                        }, new OnErrorListener() {
                            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                AppMethodBeat.i(40938);
                                ab.e("MicroMsg.F2fRcvVoiceListener", "no need play money error");
                                g.f(g.this);
                                g.this.isPlaying = false;
                                g.this.kBM = null;
                                h.pYm.e(14404, Integer.valueOf(3), bVar.cva, Integer.valueOf(7), Integer.valueOf(i), Integer.valueOf(bVar.kBZ));
                                AppMethodBeat.o(40938);
                                return false;
                            }
                        });
                        h.pYm.a(699, 2, 1, false);
                    } else {
                        ab.i("MicroMsg.F2fRcvVoiceListener", "play prefix voice: %d", Integer.valueOf(i2));
                        this.kBM = a.a(ah.getContext(), new OnCompletionListener() {
                            public final void onCompletion(MediaPlayer mediaPlayer) {
                                AppMethodBeat.i(40934);
                                ab.i("MicroMsg.F2fRcvVoiceListener", "start play money");
                                if (g.this.kBM != null && g.this.isPlaying && g.this.kBN == null) {
                                    g.a(g.this, bVar);
                                } else {
                                    ab.i("MicroMsg.F2fRcvVoiceListener", "has played");
                                }
                                g.this.kBM = null;
                                AppMethodBeat.o(40934);
                            }
                        }, new OnErrorListener() {
                            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                AppMethodBeat.i(40935);
                                ab.e("MicroMsg.F2fRcvVoiceListener", "prefix play error");
                                g.this.isPlaying = false;
                                g.this.kBM = null;
                                g.f(g.this);
                                h.pYm.e(14404, Integer.valueOf(3), bVar.cva, Integer.valueOf(7), Integer.valueOf(i), Integer.valueOf(bVar.kBZ));
                                if (g.this.kBO.isEmpty()) {
                                    g.bgE();
                                } else {
                                    g.h(g.this);
                                }
                                AppMethodBeat.o(40935);
                                return false;
                            }
                        });
                        if (this.kBM != null) {
                            ab.i("MicroMsg.F2fRcvVoiceListener", "prefix duration: %s", Integer.valueOf(this.kBM.getDuration()));
                            al.n(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(40936);
                                    if (g.this.kBM != null && g.this.isPlaying && g.this.kBN == null) {
                                        ab.i("MicroMsg.F2fRcvVoiceListener", "this play may error");
                                        h.pYm.a(699, 1, 1, false);
                                    }
                                    AppMethodBeat.o(40936);
                                }
                            }, (long) (r0 + 1000));
                            AppMethodBeat.o(40952);
                        }
                    }
                    AppMethodBeat.o(40952);
                } else if (this.isPlaying && this.kBN == null) {
                    a(bVar);
                    AppMethodBeat.o(40952);
                } else {
                    ab.i("MicroMsg.F2fRcvVoiceListener", "has played");
                    AppMethodBeat.o(40952);
                }
            } else {
                this.isPlaying = false;
                AppMethodBeat.o(40952);
            }
        }
    }

    private void a(final b bVar) {
        AppMethodBeat.i(40953);
        this.kBN = a.a(bVar.fileName, new OnCompletionListener() {
            public final void onCompletion(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(40939);
                ab.i("MicroMsg.F2fRcvVoiceListener", "play done");
                g.this.isPlaying = false;
                g.this.kBN = null;
                g.f(g.this);
                if (com.tencent.mm.plugin.collect.a.a.bgv().kBA) {
                    h.pYm.e(14404, Integer.valueOf(1), bVar.cva, "", "", Integer.valueOf(bVar.kBZ));
                } else {
                    h.pYm.e(14404, Integer.valueOf(2), bVar.cva, "", "", Integer.valueOf(bVar.kBZ));
                }
                if (g.this.kBO.isEmpty()) {
                    g.bgE();
                    AppMethodBeat.o(40939);
                    return;
                }
                g.h(g.this);
                AppMethodBeat.o(40939);
            }
        }, new OnErrorListener() {
            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                AppMethodBeat.i(40940);
                ab.e("MicroMsg.F2fRcvVoiceListener", "play money error: %s, %s", Integer.valueOf(i), Integer.valueOf(i2));
                g.this.isPlaying = false;
                g.this.kBN = null;
                h.pYm.e(14404, Integer.valueOf(3), bVar.cva, Integer.valueOf(7), Integer.valueOf(i), Integer.valueOf(bVar.kBZ));
                g.f(g.this);
                if (g.this.kBO.isEmpty()) {
                    g.bgE();
                } else {
                    g.h(g.this);
                }
                AppMethodBeat.o(40940);
                return false;
            }
        });
        AppMethodBeat.o(40953);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(40954);
        ab.i("MicroMsg.F2fRcvVoiceListener", "errType:" + i + " errCode:" + i2 + " errMsg:" + str + " scenetype:" + mVar.getType());
        if (mVar instanceof i) {
            i iVar = (i) mVar;
            if (i == 0 && i2 == 0) {
                ab.i("MicroMsg.F2fRcvVoiceListener", "overtime: %s retcode: %s", Integer.valueOf(iVar.kCf.vWk), Integer.valueOf(iVar.kCf.kCl));
                if (iVar.kCf.vWk == 1) {
                    ab.w("MicroMsg.F2fRcvVoiceListener", "skip over 10min: %s", Long.valueOf(iVar.cvc));
                    h.pYm.e(14404, Integer.valueOf(3), iVar.cva, Integer.valueOf(1), "", Integer.valueOf(1));
                    AppMethodBeat.o(40954);
                    return;
                } else if (iVar.kCf.kCl == 0) {
                    a(1, iVar.kCf.vWj.wR, iVar.kCf.vWi, iVar.cva, iVar.kCf.vWk, false);
                    h.pYm.e(15763, iVar.cva, Integer.valueOf(1), Integer.valueOf(tH(iVar.cvd)), Long.valueOf(iVar.kCg), Integer.valueOf(bgD()));
                    AppMethodBeat.o(40954);
                    return;
                } else if (iVar.kCf.kCl <= 100) {
                    ab.i("MicroMsg.F2fRcvVoiceListener", "play default sound only");
                    ar(1, iVar.cva);
                    h.pYm.e(15763, iVar.cva, Integer.valueOf(2), Integer.valueOf(tH(iVar.cvd)), Long.valueOf(iVar.kCg), Integer.valueOf(bgD()));
                    AppMethodBeat.o(40954);
                    return;
                } else {
                    ab.w("MicroMsg.F2fRcvVoiceListener", "retcode > 100, don't play");
                    h.pYm.e(14404, Integer.valueOf(3), iVar.cva, Integer.valueOf(2), "", Integer.valueOf(1));
                    h.pYm.e(15763, iVar.cva, Integer.valueOf(2), Integer.valueOf(tH(iVar.cvd)), Long.valueOf(iVar.kCg), Integer.valueOf(bgD()));
                    AppMethodBeat.o(40954);
                    return;
                }
            }
            ab.e("MicroMsg.F2fRcvVoiceListener", "net error: %s", iVar);
            ar(1, iVar.cva);
            h.pYm.e(15763, iVar.cva, Integer.valueOf(2), Integer.valueOf(tH(iVar.cvd)), Long.valueOf(iVar.kCg), Integer.valueOf(bgD()));
            h.pYm.e(14404, Integer.valueOf(3), iVar.cva, Integer.valueOf(3), "", Integer.valueOf(1));
            AppMethodBeat.o(40954);
            return;
        }
        if (mVar instanceof n) {
            n nVar = (n) mVar;
            if (i != 0 || i2 != 0) {
                ab.e("MicroMsg.F2fRcvVoiceListener", "net error: %s", nVar);
                h.pYm.e(14404, Integer.valueOf(3), nVar.cva, Integer.valueOf(3), "", Integer.valueOf(2));
            } else if (nVar.kCB.kCl == 0) {
                com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(kBK);
                if (bVar.exists() || bVar.mkdirs()) {
                    String str2 = kBK + UUID.randomUUID().toString() + ".tmp";
                    ab.i("MicroMsg.F2fRcvVoiceListener", "fileName: %s", str2);
                    if (t(str2, nVar.kCB.vWj.wR)) {
                        b bVar2 = new b(this, (byte) 0);
                        bVar2.fileName = str2;
                        bVar2.cAO = nVar.kCB.vWi;
                        bVar2.kBZ = 2;
                        this.kBO.add(bVar2);
                        bgC();
                        AppMethodBeat.o(40954);
                        return;
                    }
                    ab.i("MicroMsg.F2fRcvVoiceListener", "save file fail");
                    AppMethodBeat.o(40954);
                    return;
                }
                ab.i("MicroMsg.F2fRcvVoiceListener", "mk dir fail");
                AppMethodBeat.o(40954);
                return;
            } else {
                h.pYm.e(14404, Integer.valueOf(3), nVar.cva, Integer.valueOf(2), "", Integer.valueOf(2));
                AppMethodBeat.o(40954);
                return;
            }
        }
        AppMethodBeat.o(40954);
    }

    public final void a(int i, String str, String str2, String str3, int i2, String str4, byte[] bArr) {
        AppMethodBeat.i(40955);
        ab.i("MicroMsg.F2fRcvVoiceListener", "errorCode:%s outTradeNo:%s type:%s content:%s packId:%s overtimeFlag:%s", Integer.valueOf(i), str, str2, str3, str4, Integer.valueOf(0));
        int Ib = Ib(str2);
        if (i < 0) {
            ar(Ib, str);
            a(6, str, Ib, str3, i2, str4, 9);
            AppMethodBeat.o(40955);
            return;
        }
        a(Ib, bArr, 1, str, 0, true);
        a(5, str, Ib, str3, i2, str4, 0);
        AppMethodBeat.o(40955);
    }

    private void a(int i, byte[] bArr, int i2, String str, int i3, boolean z) {
        AppMethodBeat.i(40956);
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(kBK);
        if (bVar.exists() || bVar.mkdirs()) {
            String str2 = kBK + UUID.randomUUID().toString() + ".tmp";
            ab.i("MicroMsg.F2fRcvVoiceListener", "fileName: %s", str2);
            if (t(str2, bArr)) {
                b bVar2 = new b(this, (byte) 0);
                bVar2.fileName = str2;
                bVar2.cAO = i2;
                bVar2.kBZ = i;
                bVar2.cva = str;
                bVar2.kCa = i3;
                bVar2.kCb = z;
                this.kBO.add(bVar2);
                bgC();
                AppMethodBeat.o(40956);
                return;
            }
            ab.i("MicroMsg.F2fRcvVoiceListener", "save file fail");
            AppMethodBeat.o(40956);
            return;
        }
        ab.i("MicroMsg.F2fRcvVoiceListener", "mk dir fail");
        AppMethodBeat.o(40956);
    }

    private void ar(int i, String str) {
        AppMethodBeat.i(40957);
        ab.i("MicroMsg.F2fRcvVoiceListener", "play default sound only");
        b bVar = new b(this, (byte) 0);
        bVar.kBZ = i;
        bVar.cva = str;
        this.kBO.add(bVar);
        bgC();
        AppMethodBeat.o(40957);
    }

    private static int tH(int i) {
        if (i == 1) {
            return 3;
        }
        return 2;
    }

    private static int Ib(String str) {
        AppMethodBeat.i(40958);
        int i = 0;
        if (str.equals("wx_f2f")) {
            i = 1;
        } else if (str.equals("wx_md")) {
            i = 2;
        }
        AppMethodBeat.o(40958);
        return i;
    }

    private void a(int i, String str, int i2, String str2, int i3, String str3, int i4) {
        AppMethodBeat.i(40959);
        this.kBT = new bf();
        this.kBT.cVR = (long) i;
        this.kBT.fV(str);
        if (!bo.gW(i4, 0)) {
            this.kBT.dbV = (long) i4;
        }
        this.kBT.dbX = (long) i2;
        this.kBT.fW(str2);
        this.kBT.dca = (long) i3;
        if (bo.gW(i, 6)) {
            this.kBT.fX(str3);
        }
        this.kBT.ajK();
        AppMethodBeat.o(40959);
    }

    private static int bgD() {
        AppMethodBeat.i(40960);
        if (com.tencent.mm.compatible.b.g.KK().KP()) {
            AppMethodBeat.o(40960);
            return 1;
        }
        AppMethodBeat.o(40960);
        return 0;
    }

    static /* synthetic */ void f(g gVar) {
        AppMethodBeat.i(40963);
        ab.i("MicroMsg.F2fRcvVoiceListener", "reset user vol: %s", Integer.valueOf(gVar.kBP));
        com.tencent.mm.compatible.b.g.KK().bR(3, gVar.kBP);
        AppMethodBeat.o(40963);
    }
}
