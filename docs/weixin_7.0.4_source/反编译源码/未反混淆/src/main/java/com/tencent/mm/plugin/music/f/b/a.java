package com.tencent.mm.plugin.music.f.b;

import com.google.android.exoplayer2.d.b;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.id3.UrlLinkFrame;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.rtmp.sharp.jni.QLog;
import java.text.NumberFormat;
import java.util.Locale;

public final class a {
    private static final NumberFormat oNW;

    static {
        AppMethodBeat.i(137661);
        NumberFormat instance = NumberFormat.getInstance(Locale.US);
        oNW = instance;
        instance.setMinimumFractionDigits(2);
        oNW.setMaximumFractionDigits(2);
        oNW.setGroupingUsed(false);
        AppMethodBeat.o(137661);
    }

    public static void bUI() {
        AppMethodBeat.i(137658);
        b.DEBUG = false;
        b.a(new com.google.android.exoplayer2.d.a() {
            public final void i(String str, String str2, Object... objArr) {
                AppMethodBeat.i(137655);
                ab.i(str, str2, objArr);
                AppMethodBeat.o(137655);
            }

            public final void w(String str, String str2, Object... objArr) {
                AppMethodBeat.i(137656);
                ab.w(str, str2, objArr);
                AppMethodBeat.o(137656);
            }

            public final void e(String str, String str2, Object... objArr) {
                AppMethodBeat.i(137657);
                ab.e(str, str2, objArr);
                AppMethodBeat.o(137657);
            }
        });
        AppMethodBeat.o(137658);
    }

    public static String jo(long j) {
        AppMethodBeat.i(137659);
        String str;
        if (j == -9223372036854775807L) {
            str = "?";
            AppMethodBeat.o(137659);
            return str;
        }
        str = oNW.format((double) (((float) j) / 1000.0f));
        AppMethodBeat.o(137659);
        return str;
    }

    public static String zT(int i) {
        switch (i) {
            case 1:
                return "I";
            case 2:
                return "B";
            case 3:
                return "R";
            case 4:
                return QLog.TAG_REPORTLEVEL_USER;
            default:
                return "?";
        }
    }

    public static void a(Metadata metadata, String str) {
        AppMethodBeat.i(137660);
        for (Entry entry : metadata.beW) {
            if (entry instanceof TextInformationFrame) {
                TextInformationFrame textInformationFrame = (TextInformationFrame) entry;
                ab.d("MicroMsg.ExoPlayer", str + String.format("%s: value=%s", new Object[]{textInformationFrame.id, textInformationFrame.value}));
            } else if (entry instanceof UrlLinkFrame) {
                UrlLinkFrame urlLinkFrame = (UrlLinkFrame) entry;
                ab.d("MicroMsg.ExoPlayer", str + String.format("%s: url=%s", new Object[]{urlLinkFrame.id, urlLinkFrame.url}));
            } else if (entry instanceof PrivFrame) {
                PrivFrame privFrame = (PrivFrame) entry;
                ab.d("MicroMsg.ExoPlayer", str + String.format("%s: owner=%s", new Object[]{privFrame.id, privFrame.bfz}));
            } else if (entry instanceof GeobFrame) {
                GeobFrame geobFrame = (GeobFrame) entry;
                ab.d("MicroMsg.ExoPlayer", str + String.format("%s: mimeType=%s, filename=%s, description=%s", new Object[]{geobFrame.id, geobFrame.mimeType, geobFrame.filename, geobFrame.description}));
            } else if (entry instanceof ApicFrame) {
                ApicFrame apicFrame = (ApicFrame) entry;
                ab.d("MicroMsg.ExoPlayer", str + String.format("%s: mimeType=%s, description=%s", new Object[]{apicFrame.id, apicFrame.mimeType, apicFrame.description}));
            } else if (entry instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) entry;
                ab.d("MicroMsg.ExoPlayer", str + String.format("%s: language=%s, description=%s", new Object[]{commentFrame.id, commentFrame.aOt, commentFrame.description}));
            } else if (entry instanceof Id3Frame) {
                Id3Frame id3Frame = (Id3Frame) entry;
                ab.d("MicroMsg.ExoPlayer", str + String.format("%s", new Object[]{id3Frame.id}));
            } else if (entry instanceof EventMessage) {
                EventMessage eventMessage = (EventMessage) entry;
                ab.d("MicroMsg.ExoPlayer", str + String.format("EMSG: scheme=%s, id=%d, value=%s", new Object[]{eventMessage.bfh, Long.valueOf(eventMessage.id), eventMessage.value}));
            }
        }
        AppMethodBeat.o(137660);
    }
}
