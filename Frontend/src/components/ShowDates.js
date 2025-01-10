const ShowDates = () => {
  const today = new Date();

  const weekday = {
    1: "MON",
    2: "TUE",
    3: "WED",
    4: "THU",
    5: "FRI",
    6: "SAT",
    0: "SUN",
  };

  return (
    <div style={{ display: "flex", textAlign: "center" }}>
      <div className="mx-2 date-btn">
        <p className="date-para">TODAY</p>
        <p className="date-para">{today.getDate()}</p>
      </div>
      <div className="mx-2 date-btn">
        <p className="date-para">{weekday[(today.getDay() + 1) % 7]}</p>
        <p className="date-para">{today.getDate() + 1}</p>
      </div>
      <div className="mx-2 date-btn">
        <p className="date-para">{weekday[(today.getDay() + 2) % 7]}</p>
        <p className="date-para">{today.getDate() + 2}</p>
      </div>
    </div>
  );
};

export default ShowDates;
