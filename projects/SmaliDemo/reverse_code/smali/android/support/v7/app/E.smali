.class Landroid/support/v7/app/E;
.super Ljava/lang/Object;
.source ""


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v7/app/E$a;
    }
.end annotation


# static fields
.field private static a:Landroid/support/v7/app/E;


# instance fields
.field private final b:Landroid/content/Context;

.field private final c:Landroid/location/LocationManager;

.field private final d:Landroid/support/v7/app/E$a;


# direct methods
.method constructor <init>(Landroid/content/Context;Landroid/location/LocationManager;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "locationManager"    # Landroid/location/LocationManager;

    .line 69
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 66
    new-instance v0, Landroid/support/v7/app/E$a;

    invoke-direct {v0}, Landroid/support/v7/app/E$a;-><init>()V

    iput-object v0, p0, Landroid/support/v7/app/E;->d:Landroid/support/v7/app/E$a;

    .line 70
    iput-object p1, p0, Landroid/support/v7/app/E;->b:Landroid/content/Context;

    .line 71
    iput-object p2, p0, Landroid/support/v7/app/E;->c:Landroid/location/LocationManager;

    .line 72
    return-void
.end method

.method private a(Ljava/lang/String;)Landroid/location/Location;
    .locals 3
    .param p1, "provider"    # Ljava/lang/String;

    .line 134
    :try_start_0
    iget-object v0, p0, Landroid/support/v7/app/E;->c:Landroid/location/LocationManager;

    invoke-virtual {v0, p1}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 135
    iget-object v0, p0, Landroid/support/v7/app/E;->c:Landroid/location/LocationManager;

    invoke-virtual {v0, p1}, Landroid/location/LocationManager;->getLastKnownLocation(Ljava/lang/String;)Landroid/location/Location;

    move-result-object v0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-object v0

    .line 139
    :cond_0
    goto :goto_0

    .line 137
    :catch_0
    move-exception v0

    .line 138
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "TwilightManager"

    const-string v2, "Failed to get last known location"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 140
    .end local v0    # "e":Ljava/lang/Exception;
    :goto_0
    const/4 v0, 0x0

    return-object v0
.end method

.method static a(Landroid/content/Context;)Landroid/support/v7/app/E;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .line 50
    sget-object v0, Landroid/support/v7/app/E;->a:Landroid/support/v7/app/E;

    if-nez v0, :cond_0

    .line 51
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object p0

    .line 52
    new-instance v0, Landroid/support/v7/app/E;

    .line 53
    const-string v1, "location"

    invoke-virtual {p0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/location/LocationManager;

    invoke-direct {v0, p0, v1}, Landroid/support/v7/app/E;-><init>(Landroid/content/Context;Landroid/location/LocationManager;)V

    sput-object v0, Landroid/support/v7/app/E;->a:Landroid/support/v7/app/E;

    .line 55
    :cond_0
    sget-object v0, Landroid/support/v7/app/E;->a:Landroid/support/v7/app/E;

    return-object v0
.end method

.method private a(Landroid/location/Location;)V
    .locals 22
    .param p1, "location"    # Landroid/location/Location;

    .line 148
    move-object/from16 v0, p0

    iget-object v1, v0, Landroid/support/v7/app/E;->d:Landroid/support/v7/app/E$a;

    .line 149
    .local v1, "state":Landroid/support/v7/app/E$a;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v9

    .line 150
    .local v9, "now":J
    invoke-static {}, Landroid/support/v7/app/D;->a()Landroid/support/v7/app/D;

    move-result-object v11

    .line 153
    .local v11, "calculator":Landroid/support/v7/app/D;
    const-wide/32 v12, 0x5265c00

    sub-long v3, v9, v12

    .line 154
    invoke-virtual/range {p1 .. p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v5

    invoke-virtual/range {p1 .. p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v7

    .line 153
    move-object v2, v11

    invoke-virtual/range {v2 .. v8}, Landroid/support/v7/app/D;->a(JDD)V

    .line 155
    iget-wide v14, v11, Landroid/support/v7/app/D;->b:J

    .line 158
    .local v14, "yesterdaySunset":J
    invoke-virtual/range {p1 .. p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v5

    invoke-virtual/range {p1 .. p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v7

    move-wide v3, v9

    invoke-virtual/range {v2 .. v8}, Landroid/support/v7/app/D;->a(JDD)V

    .line 159
    iget v2, v11, Landroid/support/v7/app/D;->d:I

    const/4 v3, 0x1

    if-ne v2, v3, :cond_0

    goto :goto_0

    :cond_0
    const/4 v3, 0x0

    :goto_0
    move v7, v3

    .line 160
    .local v7, "isNight":Z
    iget-wide v5, v11, Landroid/support/v7/app/D;->c:J

    .line 161
    .local v5, "todaySunrise":J
    iget-wide v3, v11, Landroid/support/v7/app/D;->b:J

    .line 164
    .local v3, "todaySunset":J
    add-long/2addr v12, v9

    .line 165
    invoke-virtual/range {p1 .. p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v16

    invoke-virtual/range {p1 .. p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v18

    .line 164
    move-object v2, v11

    move-wide/from16 v20, v14

    move-wide v14, v3

    .end local v3    # "todaySunset":J
    .local v14, "todaySunset":J
    .local v20, "yesterdaySunset":J
    move-wide v3, v12

    move-wide v12, v5

    .end local v5    # "todaySunrise":J
    .local v12, "todaySunrise":J
    move-wide/from16 v5, v16

    move v0, v7

    .end local v7    # "isNight":Z
    .local v0, "isNight":Z
    move-wide/from16 v7, v18

    invoke-virtual/range {v2 .. v8}, Landroid/support/v7/app/D;->a(JDD)V

    .line 166
    iget-wide v2, v11, Landroid/support/v7/app/D;->c:J

    .line 169
    .local v2, "tomorrowSunrise":J
    const-wide/16 v4, 0x0

    .line 170
    .local v4, "nextUpdate":J
    const-wide/16 v6, -0x1

    cmp-long v8, v12, v6

    if-eqz v8, :cond_4

    cmp-long v8, v14, v6

    if-nez v8, :cond_1

    goto :goto_2

    .line 174
    :cond_1
    cmp-long v6, v9, v14

    if-lez v6, :cond_2

    .line 175
    add-long/2addr v4, v2

    goto :goto_1

    .line 176
    :cond_2
    cmp-long v6, v9, v12

    if-lez v6, :cond_3

    .line 177
    add-long/2addr v4, v14

    goto :goto_1

    .line 179
    :cond_3
    add-long/2addr v4, v12

    .line 182
    :goto_1
    const-wide/32 v6, 0xea60

    add-long/2addr v4, v6

    goto :goto_3

    .line 172
    :cond_4
    :goto_2
    const-wide/32 v6, 0x2932e00

    add-long v4, v9, v6

    .line 186
    :goto_3
    iput-boolean v0, v1, Landroid/support/v7/app/E$a;->a:Z

    .line 187
    move-wide/from16 v6, v20

    .end local v20    # "yesterdaySunset":J
    .local v6, "yesterdaySunset":J
    iput-wide v6, v1, Landroid/support/v7/app/E$a;->b:J

    .line 188
    iput-wide v12, v1, Landroid/support/v7/app/E$a;->c:J

    .line 189
    iput-wide v14, v1, Landroid/support/v7/app/E$a;->d:J

    .line 190
    iput-wide v2, v1, Landroid/support/v7/app/E$a;->e:J

    .line 191
    iput-wide v4, v1, Landroid/support/v7/app/E$a;->f:J

    .line 192
    return-void
.end method

.method private b()Landroid/location/Location;
    .locals 8
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "MissingPermission"
        }
    .end annotation

    .line 107
    const/4 v0, 0x0

    .line 108
    .local v0, "coarseLoc":Landroid/location/Location;
    const/4 v1, 0x0

    .line 110
    .local v1, "fineLoc":Landroid/location/Location;
    iget-object v2, p0, Landroid/support/v7/app/E;->b:Landroid/content/Context;

    const-string v3, "android.permission.ACCESS_COARSE_LOCATION"

    invoke-static {v2, v3}, La/b/c/a/c;->a(Landroid/content/Context;Ljava/lang/String;)I

    move-result v2

    .line 112
    .local v2, "permission":I
    if-nez v2, :cond_0

    .line 113
    const-string v3, "network"

    invoke-direct {p0, v3}, Landroid/support/v7/app/E;->a(Ljava/lang/String;)Landroid/location/Location;

    move-result-object v0

    .line 116
    :cond_0
    iget-object v3, p0, Landroid/support/v7/app/E;->b:Landroid/content/Context;

    const-string v4, "android.permission.ACCESS_FINE_LOCATION"

    invoke-static {v3, v4}, La/b/c/a/c;->a(Landroid/content/Context;Ljava/lang/String;)I

    move-result v2

    .line 118
    if-nez v2, :cond_1

    .line 119
    const-string v3, "gps"

    invoke-direct {p0, v3}, Landroid/support/v7/app/E;->a(Ljava/lang/String;)Landroid/location/Location;

    move-result-object v1

    .line 122
    :cond_1
    if-eqz v1, :cond_3

    if-eqz v0, :cond_3

    .line 124
    invoke-virtual {v1}, Landroid/location/Location;->getTime()J

    move-result-wide v3

    invoke-virtual {v0}, Landroid/location/Location;->getTime()J

    move-result-wide v5

    cmp-long v7, v3, v5

    if-lez v7, :cond_2

    move-object v3, v1

    goto :goto_0

    :cond_2
    move-object v3, v0

    :goto_0
    return-object v3

    .line 127
    :cond_3
    if-eqz v1, :cond_4

    move-object v3, v1

    goto :goto_1

    :cond_4
    move-object v3, v0

    :goto_1
    return-object v3
.end method

.method private c()Z
    .locals 5

    .line 144
    iget-object v0, p0, Landroid/support/v7/app/E;->d:Landroid/support/v7/app/E$a;

    iget-wide v0, v0, Landroid/support/v7/app/E$a;->f:J

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    cmp-long v4, v0, v2

    if-lez v4, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method


# virtual methods
.method a()Z
    .locals 5

    .line 80
    iget-object v0, p0, Landroid/support/v7/app/E;->d:Landroid/support/v7/app/E$a;

    .line 82
    .local v0, "state":Landroid/support/v7/app/E$a;
    invoke-direct {p0}, Landroid/support/v7/app/E;->c()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 84
    iget-boolean v1, v0, Landroid/support/v7/app/E$a;->a:Z

    return v1

    .line 88
    :cond_0
    invoke-direct {p0}, Landroid/support/v7/app/E;->b()Landroid/location/Location;

    move-result-object v1

    .line 89
    .local v1, "location":Landroid/location/Location;
    if-eqz v1, :cond_1

    .line 90
    invoke-direct {p0, v1}, Landroid/support/v7/app/E;->a(Landroid/location/Location;)V

    .line 91
    iget-boolean v2, v0, Landroid/support/v7/app/E$a;->a:Z

    return v2

    .line 94
    :cond_1
    const-string v2, "TwilightManager"

    const-string v3, "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values."

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 100
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v2

    .line 101
    .local v2, "calendar":Ljava/util/Calendar;
    const/16 v3, 0xb

    invoke-virtual {v2, v3}, Ljava/util/Calendar;->get(I)I

    move-result v3

    .line 102
    .local v3, "hour":I
    const/4 v4, 0x6

    if-lt v3, v4, :cond_3

    const/16 v4, 0x16

    if-lt v3, v4, :cond_2

    goto :goto_0

    :cond_2
    const/4 v4, 0x0

    goto :goto_1

    :cond_3
    :goto_0
    const/4 v4, 0x1

    :goto_1
    return v4
.end method
