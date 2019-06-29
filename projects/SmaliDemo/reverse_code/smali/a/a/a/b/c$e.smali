.class abstract La/a/a/b/c$e;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Ljava/util/Iterator;
.implements La/a/a/b/c$f;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La/a/a/b/c;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x40a
    name = "e"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<K:",
        "Ljava/lang/Object;",
        "V:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Ljava/util/Iterator<",
        "Ljava/util/Map$Entry<",
        "TK;TV;>;>;",
        "La/a/a/b/c$f<",
        "TK;TV;>;"
    }
.end annotation


# instance fields
.field a:La/a/a/b/c$c;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "La/a/a/b/c$c<",
            "TK;TV;>;"
        }
    .end annotation
.end field

.field b:La/a/a/b/c$c;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "La/a/a/b/c$c<",
            "TK;TV;>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(La/a/a/b/c$c;La/a/a/b/c$c;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La/a/a/b/c$c<",
            "TK;TV;>;",
            "La/a/a/b/c$c<",
            "TK;TV;>;)V"
        }
    .end annotation

    .line 223
    .local p0, "this":La/a/a/b/c$e;, "Landroid/arch/core/internal/SafeIterableMap$ListIterator<TK;TV;>;"
    .local p1, "start":La/a/a/b/c$c;, "Landroid/arch/core/internal/SafeIterableMap$Entry<TK;TV;>;"
    .local p2, "expectedEnd":La/a/a/b/c$c;, "Landroid/arch/core/internal/SafeIterableMap$Entry<TK;TV;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 224
    iput-object p2, p0, La/a/a/b/c$e;->a:La/a/a/b/c$c;

    .line 225
    iput-object p1, p0, La/a/a/b/c$e;->b:La/a/a/b/c$c;

    .line 226
    return-void
.end method

.method private a()La/a/a/b/c$c;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "La/a/a/b/c$c<",
            "TK;TV;>;"
        }
    .end annotation

    .line 250
    .local p0, "this":La/a/a/b/c$e;, "Landroid/arch/core/internal/SafeIterableMap$ListIterator<TK;TV;>;"
    iget-object v0, p0, La/a/a/b/c$e;->b:La/a/a/b/c$c;

    iget-object v1, p0, La/a/a/b/c$e;->a:La/a/a/b/c$c;

    if-eq v0, v1, :cond_1

    if-nez v1, :cond_0

    goto :goto_0

    .line 253
    :cond_0
    invoke-virtual {p0, v0}, La/a/a/b/c$e;->c(La/a/a/b/c$c;)La/a/a/b/c$c;

    move-result-object v0

    return-object v0

    .line 251
    :cond_1
    :goto_0
    const/4 v0, 0x0

    return-object v0
.end method


# virtual methods
.method public a(La/a/a/b/c$c;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La/a/a/b/c$c<",
            "TK;TV;>;)V"
        }
    .end annotation

    .line 235
    .local p0, "this":La/a/a/b/c$e;, "Landroid/arch/core/internal/SafeIterableMap$ListIterator<TK;TV;>;"
    .local p1, "entry":La/a/a/b/c$c;, "Landroid/arch/core/internal/SafeIterableMap$Entry<TK;TV;>;"
    iget-object v0, p0, La/a/a/b/c$e;->a:La/a/a/b/c$c;

    if-ne v0, p1, :cond_0

    iget-object v0, p0, La/a/a/b/c$e;->b:La/a/a/b/c$c;

    if-ne p1, v0, :cond_0

    .line 236
    const/4 v0, 0x0

    iput-object v0, p0, La/a/a/b/c$e;->b:La/a/a/b/c$c;

    .line 237
    iput-object v0, p0, La/a/a/b/c$e;->a:La/a/a/b/c$c;

    .line 240
    :cond_0
    iget-object v0, p0, La/a/a/b/c$e;->a:La/a/a/b/c$c;

    if-ne v0, p1, :cond_1

    .line 241
    invoke-virtual {p0, v0}, La/a/a/b/c$e;->b(La/a/a/b/c$c;)La/a/a/b/c$c;

    move-result-object v0

    iput-object v0, p0, La/a/a/b/c$e;->a:La/a/a/b/c$c;

    .line 244
    :cond_1
    iget-object v0, p0, La/a/a/b/c$e;->b:La/a/a/b/c$c;

    if-ne v0, p1, :cond_2

    .line 245
    invoke-direct {p0}, La/a/a/b/c$e;->a()La/a/a/b/c$c;

    move-result-object v0

    iput-object v0, p0, La/a/a/b/c$e;->b:La/a/a/b/c$c;

    .line 247
    :cond_2
    return-void
.end method

.method abstract b(La/a/a/b/c$c;)La/a/a/b/c$c;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La/a/a/b/c$c<",
            "TK;TV;>;)",
            "La/a/a/b/c$c<",
            "TK;TV;>;"
        }
    .end annotation
.end method

.method abstract c(La/a/a/b/c$c;)La/a/a/b/c$c;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La/a/a/b/c$c<",
            "TK;TV;>;)",
            "La/a/a/b/c$c<",
            "TK;TV;>;"
        }
    .end annotation
.end method

.method public hasNext()Z
    .locals 1

    .line 230
    .local p0, "this":La/a/a/b/c$e;, "Landroid/arch/core/internal/SafeIterableMap$ListIterator<TK;TV;>;"
    iget-object v0, p0, La/a/a/b/c$e;->b:La/a/a/b/c$c;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public bridge synthetic next()Ljava/lang/Object;
    .locals 1

    .line 218
    .local p0, "this":La/a/a/b/c$e;, "Landroid/arch/core/internal/SafeIterableMap$ListIterator<TK;TV;>;"
    invoke-virtual {p0}, La/a/a/b/c$e;->next()Ljava/util/Map$Entry;

    move-result-object v0

    return-object v0
.end method

.method public next()Ljava/util/Map$Entry;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map$Entry<",
            "TK;TV;>;"
        }
    .end annotation

    .line 258
    .local p0, "this":La/a/a/b/c$e;, "Landroid/arch/core/internal/SafeIterableMap$ListIterator<TK;TV;>;"
    iget-object v0, p0, La/a/a/b/c$e;->b:La/a/a/b/c$c;

    .line 259
    .local v0, "result":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<TK;TV;>;"
    invoke-direct {p0}, La/a/a/b/c$e;->a()La/a/a/b/c$c;

    move-result-object v1

    iput-object v1, p0, La/a/a/b/c$e;->b:La/a/a/b/c$c;

    .line 260
    return-object v0
.end method
