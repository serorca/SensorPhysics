package es.uva.sensorphysics.model

import android.hardware.Sensor
import java.util.ArrayList

object ToolsList {

    private var toolsList = ArrayList<Tool>()


    private val titles = arrayOf(
        "Accelerometer",
        "Pressure",
        "Linear Acceleration",
        "Magnetic Field",
        "Gravity",
        "Light",
        "Relative Humidity",
        "Proximity",
        "Gyroscope"
    )

    private val description = arrayOf(
        "Item one details",
        "Item two details",
        "Item three details",
        "Item four details",
        "Item five details",
        "Item six details",
        "Item seven details",
        "Item eight details"
    )

    private val types = arrayOf(
        Sensor.TYPE_ACCELEROMETER,
        Sensor.TYPE_PRESSURE,
        Sensor.TYPE_LINEAR_ACCELERATION,
        Sensor.TYPE_MAGNETIC_FIELD,
        Sensor.TYPE_GRAVITY,
        Sensor.TYPE_LIGHT,
        Sensor.TYPE_RELATIVE_HUMIDITY,
        Sensor.TYPE_PROXIMITY,
        Sensor.TYPE_GYROSCOPE
    )

    fun getToolList(): List<Tool> {
        var tool: Tool
        for (i in 0 until titles.size) {
            toolsList[i].title = titles[i]
            toolsList[i].description = description[i]
            toolsList[i].type = types[i]

        }

        return toolsList
    }
}
