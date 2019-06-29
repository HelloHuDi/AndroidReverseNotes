.class abstract La/b/b/a/k$d;
.super Ljava/lang/Object;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La/b/b/a/k;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x40a
    name = "d"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 1408
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(La/b/b/a/j;)V
    .locals 0
    .param p1, "x0"    # La/b/b/a/j;

    .line 1408
    invoke-direct {p0}, La/b/b/a/k$d;-><init>()V

    return-void
.end method


# virtual methods
.method public a()Z
    .locals 1

    .line 1415
    const/4 v0, 0x0

    return v0
.end method

.method public a([I)Z
    .locals 1
    .param p1, "stateSet"    # [I

    .line 1423
    const/4 v0, 0x0

    return v0
.end method
