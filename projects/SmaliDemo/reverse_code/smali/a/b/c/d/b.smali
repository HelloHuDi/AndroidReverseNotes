.class final La/b/c/d/b;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Ljava/util/concurrent/Callable;


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
        "Ljava/util/concurrent/Callable<",
        "La/b/c/d/f$c;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Landroid/content/Context;

.field final synthetic b:La/b/c/d/a;

.field final synthetic c:I

.field final synthetic d:Ljava/lang/String;


# direct methods
.method constructor <init>(Landroid/content/Context;La/b/c/d/a;ILjava/lang/String;)V
    .locals 0

    .line 256
    iput-object p1, p0, La/b/c/d/b;->a:Landroid/content/Context;

    iput-object p2, p0, La/b/c/d/b;->b:La/b/c/d/a;

    iput p3, p0, La/b/c/d/b;->c:I

    iput-object p4, p0, La/b/c/d/b;->d:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public call()La/b/c/d/f$c;
    .locals 4

    .line 259
    iget-object v0, p0, La/b/c/d/b;->a:Landroid/content/Context;

    iget-object v1, p0, La/b/c/d/b;->b:La/b/c/d/a;

    iget v2, p0, La/b/c/d/b;->c:I

    invoke-static {v0, v1, v2}, La/b/c/d/f;->a(Landroid/content/Context;La/b/c/d/a;I)La/b/c/d/f$c;

    move-result-object v0

    .line 260
    .local v0, "typeface":La/b/c/d/f$c;
    iget-object v1, v0, La/b/c/d/f$c;->a:Landroid/graphics/Typeface;

    if-eqz v1, :cond_0

    .line 261
    sget-object v2, La/b/c/d/f;->a:La/b/c/f/i;

    iget-object v3, p0, La/b/c/d/b;->d:Ljava/lang/String;

    invoke-virtual {v2, v3, v1}, La/b/c/f/i;->a(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 263
    :cond_0
    return-object v0
.end method

.method public bridge synthetic call()Ljava/lang/Object;
    .locals 1

    .line 256
    invoke-virtual {p0}, La/b/c/d/b;->call()La/b/c/d/f$c;

    move-result-object v0

    return-object v0
.end method
