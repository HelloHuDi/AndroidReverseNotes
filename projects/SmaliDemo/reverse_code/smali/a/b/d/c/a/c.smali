.class La/b/d/c/a/c;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = La/b/d/c/a/d;->a(I)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:La/b/d/c/a/d;


# direct methods
.method constructor <init>(La/b/d/c/a/d;)V
    .locals 0
    .param p1, "this$0"    # La/b/d/c/a/d;

    .line 471
    iput-object p1, p0, La/b/d/c/a/c;->a:La/b/d/c/a/d;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .line 474
    iget-object v0, p0, La/b/d/c/a/c;->a:La/b/d/c/a/d;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, La/b/d/c/a/d;->a(Z)V

    .line 475
    iget-object v0, p0, La/b/d/c/a/c;->a:La/b/d/c/a/d;

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->invalidateSelf()V

    .line 476
    return-void
.end method
