const Items = ({ items }) => {
    return (
        <div>
            <center><h1 style={{fontSize: "30px"}}>Ollivanders' Items</h1></center>
            <table class="pf-c-table pf-m-grid-md" role="grid" aria-label="Supersonic Subatomic Items" id="table-basic">
                <caption>Supersonic Subatomic Items</caption>
                <thead>
                    <tr role="row">
                        <th role="columnheader" scope="col">Nombre</th>
                    </tr>
                </thead>
                {items.map((item) => (
                    <tbody>
                        <tr role="row">
                            <td role="cell" data-label="Particle name">{item.nombre}</td>
                        </tr>
                    </tbody>
                ))}
            </table>
        </div>

    )
};

export default Items