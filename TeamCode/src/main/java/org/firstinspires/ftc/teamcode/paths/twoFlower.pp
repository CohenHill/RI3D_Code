{
  "startPoint": {
    "x": 56,
    "y": 8,
    "name": "",
    "locked": false,
    "headingDeg": 90
  },
  "lines": [
    {
      "id": "line-mtzbr44v-uxzezu",
      "color": "#DC5B85",
      "name": "Launch Initial",
      "locked": false,
      "waitBeforeMs": 0,
      "waitAfterMs": 0,
      "waitBeforeName": "",
      "waitAfterName": "",
      "kind": "atomic",
      "endPoint": {
        "x": 56,
        "y": 10
      },
      "controlPoints": [],
      "heading": {
        "type": "constant",
        "reverse": false,
        "degrees": 90
      }
    },
    {
      "id": "line-mtzboz06-t2ibtk",
      "color": "#ffc516",
      "name": "Flower 1",
      "locked": false,
      "waitBeforeMs": 0,
      "waitAfterMs": 0,
      "waitBeforeName": "",
      "waitAfterName": "",
      "kind": "atomic",
      "endPoint": {
        "x": 8.5,
        "y": 47
      },
      "controlPoints": [
        {
          "x": 54,
          "y": 45
        }
      ],
      "heading": {
        "type": "linear",
        "startDeg": 90,
        "endDeg": 180
      }
    },
    {
      "id": "line-mtzbswmi-1lhz81",
      "color": "#65895B",
      "name": "Launch Flower 1",
      "locked": false,
      "waitBeforeMs": 0,
      "waitAfterMs": 0,
      "waitBeforeName": "",
      "waitAfterName": "",
      "kind": "atomic",
      "endPoint": {
        "x": 30,
        "y": 110
      },
      "controlPoints": [],
      "heading": {
        "type": "linear",
        "reverse": true,
        "startDeg": 180,
        "endDeg": 310
      }
    },
    {
      "id": "line-mtze3486-k6ptqa",
      "color": "#8695BD",
      "name": "",
      "locked": false,
      "waitBeforeMs": 0,
      "waitAfterMs": 0,
      "waitBeforeName": "",
      "waitAfterName": "",
      "kind": "atomic",
      "endPoint": {
        "x": 47,
        "y": 133
      },
      "controlPoints": [],
      "heading": {
        "type": "linear",
        "reverse": true,
        "degrees": 0,
        "startDeg": 310,
        "endDeg": 90
      }
    },
    {
      "id": "line-mtze3lkr-f9wxdb",
      "color": "#D7A58D",
      "name": "",
      "locked": false,
      "waitBeforeMs": 0,
      "waitAfterMs": 0,
      "waitBeforeName": "",
      "waitAfterName": "",
      "kind": "atomic",
      "endPoint": {
        "x": 30,
        "y": 110
      },
      "controlPoints": [],
      "heading": {
        "type": "linear",
        "reverse": true,
        "degrees": 0,
        "startDeg": 90,
        "endDeg": 310
      }
    },
    {
      "id": "line-mtze47xa-8f44uk",
      "color": "#DC7BD6",
      "name": "",
      "locked": false,
      "waitBeforeMs": 0,
      "waitAfterMs": 0,
      "waitBeforeName": "",
      "waitAfterName": "",
      "kind": "atomic",
      "endPoint": {
        "x": 15,
        "y": 110
      },
      "controlPoints": [],
      "heading": {
        "type": "constant",
        "reverse": true,
        "degrees": 310
      }
    }
  ],
  "shapes": [
    {
      "id": "triangle-1",
      "name": "Red Goal",
      "vertices": [
        {
          "x": 141.5,
          "y": 70
        },
        {
          "x": 141.5,
          "y": 141.5
        },
        {
          "x": 118.3,
          "y": 141.5
        },
        {
          "x": 135.5,
          "y": 118
        },
        {
          "x": 136.3,
          "y": 70.2
        }
      ],
      "color": "#dc2626",
      "fillColor": "#ff6b6b"
    },
    {
      "id": "triangle-2",
      "name": "Blue Goal",
      "vertices": [
        {
          "x": 6.2,
          "y": 116.9
        },
        {
          "x": 25,
          "y": 141.5
        },
        {
          "x": 0,
          "y": 141.5
        },
        {
          "x": 0,
          "y": 70
        },
        {
          "x": 6,
          "y": 70
        }
      ],
      "color": "#2563eb",
      "fillColor": "#60a5fa"
    }
  ],
  "sequence": [
    {
      "kind": "path",
      "lineId": "line-mtzbr44v-uxzezu"
    },
    {
      "kind": "path",
      "lineId": "line-mtzboz06-t2ibtk"
    },
    {
      "kind": "path",
      "lineId": "line-mtzbswmi-1lhz81"
    },
    {
      "kind": "path",
      "lineId": "line-mtze3486-k6ptqa"
    },
    {
      "kind": "path",
      "lineId": "line-mtze3lkr-f9wxdb"
    },
    {
      "kind": "path",
      "lineId": "line-mtze47xa-8f44uk"
    }
  ],
  "fieldPoints": [],
  "version": "1.5.0",
  "timestamp": "2026-09-13T05:45:50.861Z"
}