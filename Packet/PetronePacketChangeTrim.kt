package kr.co.byrobot.openapi.Packet

import kr.co.byrobot.openapi.Data.PetroneTrimDrive
import kr.co.byrobot.openapi.Data.PetroneTrimFlight
import kr.co.byrobot.openapi.Enum.PetroneDataType

/**
 * Created by byrobot on 2017. 9. 26..
 */
class PetronePacketChangeTrim : PetronePacket {
    override val size: Int = 10
    override val index: Int = 0

    var flight:PetroneTrimFlight = PetroneTrimFlight()
    var drive:PetroneTrimDrive = PetroneTrimDrive()

    override fun decode(data: PetroneByteArray) : Boolean{
        return true
    }

    override fun encode() : PetroneByteArray {
        var data : PetroneByteArray = PetroneByteArray(size + 1);
        data.set(value = PetroneDataType.TrimAll)
        data.set(value = flight.roll)
        data.set(value = flight.pitch)
        data.set(value = flight.yaw)
        data.set(value = flight.throttle)
        data.set(value = drive.wheel)
        return data
    }

    override fun encodeSerial() : PetroneByteArray {
        var data : PetroneByteArray = PetroneByteArray(size + 2);
        data.set(value = PetroneDataType.Request);
        data.set(value = size.toByte());
        data.set(value = flight.roll)
        data.set(value = flight.pitch)
        data.set(value = flight.yaw)
        data.set(value = flight.throttle)
        data.set(value = drive.wheel)
        return data
    }
}