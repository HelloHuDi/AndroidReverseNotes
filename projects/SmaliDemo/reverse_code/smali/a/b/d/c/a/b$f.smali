.class abstract La/b/d/c/a/b$f;
.super Ljava/lang/Object;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La/b/d/c/a/b;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x40a
    name = "f"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 352
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(La/b/d/c/a/a;)V
    .locals 0
    .param p1, "x0"    # La/b/d/c/a/a;

    .line 352
    invoke-direct {p0}, La/b/d/c/a/b$f;-><init>()V

    return-void
.end method


# virtual methods
.method public a()Z
    .locals 1

    .line 362
    const/4 v0, 0x0

    return v0
.end method

.method public b()V
    .locals 0

    .line 359
    return-void
.end method

.method public abstract c()V
.end method

.method public abstract d()V
.end method
