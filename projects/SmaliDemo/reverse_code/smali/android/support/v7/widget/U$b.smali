.class Landroid/support/v7/widget/U$b;
.super Landroid/database/DataSetObserver;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/widget/U;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "b"
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/widget/U;


# direct methods
.method constructor <init>(Landroid/support/v7/widget/U;)V
    .locals 0

    .line 1323
    iput-object p1, p0, Landroid/support/v7/widget/U$b;->a:Landroid/support/v7/widget/U;

    invoke-direct {p0}, Landroid/database/DataSetObserver;-><init>()V

    .line 1324
    return-void
.end method


# virtual methods
.method public onChanged()V
    .locals 1

    .line 1328
    iget-object v0, p0, Landroid/support/v7/widget/U$b;->a:Landroid/support/v7/widget/U;

    invoke-virtual {v0}, Landroid/support/v7/widget/U;->b()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1330
    iget-object v0, p0, Landroid/support/v7/widget/U$b;->a:Landroid/support/v7/widget/U;

    invoke-virtual {v0}, Landroid/support/v7/widget/U;->c()V

    .line 1332
    :cond_0
    return-void
.end method

.method public onInvalidated()V
    .locals 1

    .line 1336
    iget-object v0, p0, Landroid/support/v7/widget/U$b;->a:Landroid/support/v7/widget/U;

    invoke-virtual {v0}, Landroid/support/v7/widget/U;->dismiss()V

    .line 1337
    return-void
.end method
