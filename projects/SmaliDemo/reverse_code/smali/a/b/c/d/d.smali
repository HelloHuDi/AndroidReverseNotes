.class final La/b/c/d/d;
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
.field final synthetic a:Ljava/lang/String;


# direct methods
.method constructor <init>(Ljava/lang/String;)V
    .locals 0

    .line 304
    iput-object p1, p0, La/b/c/d/d;->a:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(La/b/c/d/f$c;)V
    .locals 4
    .param p1, "typeface"    # La/b/c/d/f$c;

    .line 308
    sget-object v0, La/b/c/d/f;->c:Ljava/lang/Object;

    monitor-enter v0

    .line 309
    const/4 v1, 0x0

    :try_start_0
    sget-object v2, La/b/c/d/f;->d:La/b/c/f/m;

    iget-object v3, p0, La/b/c/d/d;->a:Ljava/lang/String;

    invoke-virtual {v2, v3}, La/b/c/f/m;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/ArrayList;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-object v1, v2

    .line 310
    .local v1, "replies":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v4/provider/SelfDestructiveThread$ReplyCallback<Landroid/support/v4/provider/FontsContractCompat$TypefaceResult;>;>;"
    if-nez v1, :cond_0

    .line 311
    :try_start_1
    monitor-exit v0

    return-void

    .line 313
    :cond_0
    sget-object v2, La/b/c/d/f;->d:La/b/c/f/m;

    iget-object v3, p0, La/b/c/d/d;->a:Ljava/lang/String;

    invoke-virtual {v2, v3}, La/b/c/f/m;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 314
    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 315
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-ge v0, v2, :cond_1

    .line 316
    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, La/b/c/d/k$a;

    invoke-interface {v2, p1}, La/b/c/d/k$a;->a(Ljava/lang/Object;)V

    .line 315
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 318
    .end local v0    # "i":I
    :cond_1
    return-void

    .line 314
    .end local v1    # "replies":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v4/provider/SelfDestructiveThread$ReplyCallback<Landroid/support/v4/provider/FontsContractCompat$TypefaceResult;>;>;"
    :catchall_0
    move-exception v2

    .restart local v1    # "replies":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v4/provider/SelfDestructiveThread$ReplyCallback<Landroid/support/v4/provider/FontsContractCompat$TypefaceResult;>;>;"
    :goto_1
    :try_start_2
    monitor-exit v0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    throw v2

    :catchall_1
    move-exception v2

    goto :goto_1
.end method

.method public bridge synthetic a(Ljava/lang/Object;)V
    .locals 0

    .line 304
    check-cast p1, La/b/c/d/f$c;

    invoke-virtual {p0, p1}, La/b/c/d/d;->a(La/b/c/d/f$c;)V

    return-void
.end method
