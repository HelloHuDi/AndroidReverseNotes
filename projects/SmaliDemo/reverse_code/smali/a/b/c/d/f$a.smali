.class public La/b/c/d/f$a;
.super Ljava/lang/Object;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La/b/c/d/f;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "a"
.end annotation


# instance fields
.field private final a:I

.field private final b:[La/b/c/d/f$b;


# direct methods
.method public constructor <init>(I[La/b/c/d/f$b;)V
    .locals 0
    .param p1, "statusCode"    # I
    .param p2, "fonts"    # [La/b/c/d/f$b;

    .line 428
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 429
    iput p1, p0, La/b/c/d/f$a;->a:I

    .line 430
    iput-object p2, p0, La/b/c/d/f$a;->b:[La/b/c/d/f$b;

    .line 431
    return-void
.end method


# virtual methods
.method public a()[La/b/c/d/f$b;
    .locals 1

    .line 438
    iget-object v0, p0, La/b/c/d/f$a;->b:[La/b/c/d/f$b;

    return-object v0
.end method

.method public b()I
    .locals 1

    .line 434
    iget v0, p0, La/b/c/d/f$a;->a:I

    return v0
.end method
