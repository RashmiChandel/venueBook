const express = require("express")
const db = require("../db")
const utils = require("../utils")

const router = express.Router()


router.post("/bookvenue", (request, response) => {
    const { User_id, Venue_id } = request.body
    const statement = `INSERT INTO VenueBookings(User_id,Venue_id) VALUES(?,?)`
    db.query(statement, [User_id, Venue_id], (error, result) => {
      response.send(utils.createResult(error, result))
    })
  })


module.exports = router