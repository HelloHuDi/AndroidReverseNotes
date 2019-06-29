.class public La/b/c/d/f$b;
.super Ljava/lang/Object;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La/b/c/d/f;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "b"
.end annotation


# instance fields
.field private final a:Landroid/net/Uri;

.field private final b:I

.field private final c:I

.field private final d:Z

.field private final e:I


# direct methods
.method public constructor <init>(Landroid/net/Uri;IIZI)V
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "ttcIndex"    # I
    .param p3, "weight"    # I
    .param p4, "italic"    # Z
    .param p5, "resultCode"    # I

    .line 347
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 348
    invoke-static {p1}, La/b/c/f/l;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-object v0, p1

    check-cast v0, Landroid/net/Uri;

    iput-object v0, p0, La/b/c/d/f$b;->a:Landroid/net/Uri;

    .line 349
    iput p2, p0, La/b/c/d/f$b;->b:I

    .line 350
    iput p3, p0, La/b/c/d/f$b;->c:I

    .line 351
    iput-boolean p4, p0, La/b/c/d/f$b;->d:Z

    .line 352
    iput p5, p0, La/b/c/d/f$b;->e:I

    .line 353
    return-void
.end method


# virtual methods
.method public a()I
    .locals 1

    .line 389
    iget v0, p0, La/b/c/d/f$b;->e:I

    return v0
.end method

.method public b()I
    .locals 1

    .line 366
    iget v0, p0, La/b/c/d/f$b;->b:I

    return v0
.end method

.method public c()Landroid/net/Uri;
    .locals 1

    .line 359
    iget-object v0, p0, La/b/c/d/f$b;->a:Landroid/net/Uri;

    return-object v0
.end method

.method public d()I
    .locals 1

    .line 373
    iget v0, p0, La/b/c/d/f$b;->c:I

    return v0
.end method

.method public e()Z
    .locals 1

    .line 380
    iget-boolean v0, p0, La/b/c/d/f$b;->d:Z

    return v0
.end method
