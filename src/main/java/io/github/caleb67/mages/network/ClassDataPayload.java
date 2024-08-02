package io.github.caleb67.mages.network;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import static io.github.caleb67.mages.Mages.MODID;

public record ClassDataPayload(int CLASS, int MAX_MANA) implements CustomPayload
{
    public static final Identifier CLASS_DATA = Identifier.of(MODID, "class_data");
    public static final CustomPayload.Id<ClassDataPayload> ID = new CustomPayload.Id<>(CLASS_DATA);

    public static final PacketCodec<RegistryByteBuf, ClassDataPayload> PACKET_CODEC = PacketCodec.tuple(
                                                        PacketCodecs.INTEGER, ClassDataPayload::CLASS,
                                                        PacketCodecs.INTEGER, ClassDataPayload::MAX_MANA,
                                                        ClassDataPayload::new
                                                    );

    @Override
    public Id<? extends CustomPayload> getId()
    {
        return ID;
    }
}
