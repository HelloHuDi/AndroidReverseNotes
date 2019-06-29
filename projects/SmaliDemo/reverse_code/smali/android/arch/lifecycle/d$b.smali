.class public final enum Landroid/arch/lifecycle/d$b;
.super Ljava/lang/Enum;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/arch/lifecycle/d;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "b"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Landroid/arch/lifecycle/d$b;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Landroid/arch/lifecycle/d$b;

.field public static final enum b:Landroid/arch/lifecycle/d$b;

.field public static final enum c:Landroid/arch/lifecycle/d$b;

.field public static final enum d:Landroid/arch/lifecycle/d$b;

.field public static final enum e:Landroid/arch/lifecycle/d$b;

.field private static final synthetic f:[Landroid/arch/lifecycle/d$b;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .line 157
    new-instance v0, Landroid/arch/lifecycle/d$b;

    const/4 v1, 0x0

    const-string v2, "DESTROYED"

    invoke-direct {v0, v2, v1}, Landroid/arch/lifecycle/d$b;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/arch/lifecycle/d$b;->a:Landroid/arch/lifecycle/d$b;

    .line 164
    new-instance v0, Landroid/arch/lifecycle/d$b;

    const/4 v2, 0x1

    const-string v3, "INITIALIZED"

    invoke-direct {v0, v3, v2}, Landroid/arch/lifecycle/d$b;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/arch/lifecycle/d$b;->b:Landroid/arch/lifecycle/d$b;

    .line 174
    new-instance v0, Landroid/arch/lifecycle/d$b;

    const/4 v3, 0x2

    const-string v4, "CREATED"

    invoke-direct {v0, v4, v3}, Landroid/arch/lifecycle/d$b;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/arch/lifecycle/d$b;->c:Landroid/arch/lifecycle/d$b;

    .line 184
    new-instance v0, Landroid/arch/lifecycle/d$b;

    const/4 v4, 0x3

    const-string v5, "STARTED"

    invoke-direct {v0, v5, v4}, Landroid/arch/lifecycle/d$b;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/arch/lifecycle/d$b;->d:Landroid/arch/lifecycle/d$b;

    .line 190
    new-instance v0, Landroid/arch/lifecycle/d$b;

    const/4 v5, 0x4

    const-string v6, "RESUMED"

    invoke-direct {v0, v6, v5}, Landroid/arch/lifecycle/d$b;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroid/arch/lifecycle/d$b;->e:Landroid/arch/lifecycle/d$b;

    .line 150
    const/4 v0, 0x5

    new-array v0, v0, [Landroid/arch/lifecycle/d$b;

    sget-object v6, Landroid/arch/lifecycle/d$b;->a:Landroid/arch/lifecycle/d$b;

    aput-object v6, v0, v1

    sget-object v1, Landroid/arch/lifecycle/d$b;->b:Landroid/arch/lifecycle/d$b;

    aput-object v1, v0, v2

    sget-object v1, Landroid/arch/lifecycle/d$b;->c:Landroid/arch/lifecycle/d$b;

    aput-object v1, v0, v3

    sget-object v1, Landroid/arch/lifecycle/d$b;->d:Landroid/arch/lifecycle/d$b;

    aput-object v1, v0, v4

    sget-object v1, Landroid/arch/lifecycle/d$b;->e:Landroid/arch/lifecycle/d$b;

    aput-object v1, v0, v5

    sput-object v0, Landroid/arch/lifecycle/d$b;->f:[Landroid/arch/lifecycle/d$b;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 151
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Landroid/arch/lifecycle/d$b;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .line 150
    const-class v0, Landroid/arch/lifecycle/d$b;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Landroid/arch/lifecycle/d$b;

    return-object v0
.end method

.method public static values()[Landroid/arch/lifecycle/d$b;
    .locals 1

    .line 150
    sget-object v0, Landroid/arch/lifecycle/d$b;->f:[Landroid/arch/lifecycle/d$b;

    invoke-virtual {v0}, [Landroid/arch/lifecycle/d$b;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/arch/lifecycle/d$b;

    return-object v0
.end method


# virtual methods
.method public a(Landroid/arch/lifecycle/d$b;)Z
    .locals 1
    .param p1, "state"    # Landroid/arch/lifecycle/d$b;

    .line 199
    invoke-virtual {p0, p1}, Ljava/lang/Enum;->compareTo(Ljava/lang/Enum;)I

    move-result v0

    if-ltz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method
