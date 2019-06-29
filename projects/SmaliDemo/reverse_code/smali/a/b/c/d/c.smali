.class final La/b/c/d/c;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements La/b/c/d/k$a;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = La/b/c/d/f;->a(Landroid/content/Context;La/b/c/d/a;La/b/c/a/a/h$a;Landroid/os/Handler;ZII)Landroid/graphics/Typeface;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "La/b/c/d/k$a<",
        "La/b/c/d/f$c;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:La/b/c/a/a/h$a;

.field final synthetic b:Landroid/os/Handler;


# direct methods
.method constructor <init>(La/b/c/a/a/h$a;Landroid/os/Handler;)V
    .locals 0

    .line 275
    iput-object p1, p0, La/b/c/d/c;->a:La/b/c/a/a/h$a;

    iput-object p2, p0, La/b/c/d/c;->b:Landroid/os/Handler;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(La/b/c/d/f$c;)V
    .locals 3
    .param p1, "typeface"    # La/b/c/d/f$c;

    .line 278
    if-nez p1, :cond_0

    .line 279
    iget-object v0, p0, La/b/c/d/c;->a:La/b/c/a/a/h$a;

    const/4 v1, 0x1

    iget-object v2, p0, La/b/c/d/c;->b:Landroid/os/Handler;

    invoke-virtual {v0, v1, v2}, La/b/c/a/a/h$a;->a(ILandroid/os/Handler;)V

    goto :goto_0

    .line 281
    :cond_0
    iget v0, p1, La/b/c/d/f$c;->b:I

    if-nez v0, :cond_1

    .line 282
    iget-object v0, p0, La/b/c/d/c;->a:La/b/c/a/a/h$a;

    iget-object v1, p1, La/b/c/d/f$c;->a:Landroid/graphics/Typeface;

    iget-object v2, p0, La/b/c/d/c;->b:Landroid/os/Handler;

    invoke-virtual {v0, v1, v2}, La/b/c/a/a/h$a;->a(Landroid/graphics/Typeface;Landroid/os/Handler;)V

    goto :goto_0

    .line 284
    :cond_1
    iget-object v1, p0, La/b/c/d/c;->a:La/b/c/a/a/h$a;

    iget-object v2, p0, La/b/c/d/c;->b:Landroid/os/Handler;

    invoke-virtual {v1, v0, v2}, La/b/c/a/a/h$a;->a(ILandroid/os/Handler;)V

    .line 286
    :goto_0
    return-void
.end method

.method public bridge synthetic a(Ljava/lang/Object;)V
    .locals 0

    .line 275
    check-cast p1, La/b/c/d/f$c;

    invoke-virtual {p0, p1}, La/b/c/d/c;->a(La/b/c/d/f$c;)V

    return-void
.end method
